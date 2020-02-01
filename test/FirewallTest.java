import org.junit.Assert;
import org.junit.Test;

public class FirewallTest {

  @Test
  public void acceptPacket() {
    Firewall firewall = new Firewall("rules.csv");
    Assert.assertTrue(firewall.acceptPacket("inbound", "tcp", 80, "192.168.1.2"));
    Assert.assertTrue(firewall.acceptPacket("inbound", "udp", 53, "192.168.2.1"));
    Assert.assertTrue(firewall.acceptPacket("outbound", "tcp", 10234, "192.168.10.11"));
    Assert.assertFalse(firewall.acceptPacket("inbound", "tcp", 81, "192.168.1.2"));
    Assert.assertFalse(firewall.acceptPacket("inbound", "udp", 24, "52.12.48.92"));
  }
}
