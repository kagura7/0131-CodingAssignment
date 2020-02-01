import java.util.Objects;

public class RuleKey {
  private String direction;
  private String protocol;

  public RuleKey(String direction, String protocol) {
    this.direction = direction;
    this.protocol = protocol;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RuleKey ruleKey = (RuleKey) o;
    return direction.equals(ruleKey.direction) &&
            protocol.equals(ruleKey.protocol);
  }

  @Override
  public int hashCode() {
    return Objects.hash(direction, protocol);
  }
}
