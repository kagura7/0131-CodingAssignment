import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Firewall {

  private Map<RuleKey, List<Rule>> ruleContainers = new HashMap<>();

  public Firewall(String csvPath) {
    try {
      String line = "";
      BufferedReader br = new BufferedReader(new FileReader(csvPath));
      while ((line = br.readLine()) != null) {
        String[] columns = line.split(",");
        Rule rule = new Rule(columns);
        RuleKey ruleKey = new RuleKey(rule.getDirection(), rule.getProtocol());
        ruleContainers.putIfAbsent(ruleKey, new ArrayList<>());
        ruleContainers.get(ruleKey).add(rule);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Return if there exists a rule in the file.
   *
   * @param direction “inbound” or “outbound”
   * @param protocol  exactly one of “tcp” or “udp”, all lowercase
   * @param port      an integer in the range[1,65535]
   * @param ipAddress a single well-formed IPv4address.
   * @return true or false
   */
  public boolean acceptPacket(String direction, String protocol, int port, String ipAddress) {
    RuleKey ruleKey = new RuleKey(direction, protocol);
    List<Rule> rules = ruleContainers.get(ruleKey);
    for (Rule rule : rules) {
      if (rule.apply(port, ipAddress)) {
        return true;
      }
    }
    return false;
  }
}
