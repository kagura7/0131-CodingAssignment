public class Rule {

  private String direction;
  private String protocol;
  private int minPort;
  private int maxPort;
  private IPAddress minIPAddress;
  private IPAddress maxIPAddress;

  public Rule(String[] columns) {
    direction = columns[0];
    protocol = columns[1];
    String portCol = columns[2];
    if (portCol.contains("-")) {
      String[] split = portCol.split("-");
      minPort = Integer.parseInt(split[0]);
      maxPort = Integer.parseInt(split[1]);
    } else {
      minPort = Integer.parseInt(portCol);
      maxPort = Integer.parseInt(portCol);
    }

    String ipCol = columns[3];
    if (ipCol.contains("-")) {
      String[] split = ipCol.split("-");
      minIPAddress = new IPAddress(split[0]);
      maxIPAddress = new IPAddress(split[1]);
    } else {
      minIPAddress = new IPAddress(ipCol);
      maxIPAddress = new IPAddress(ipCol);
    }
  }

  /**
   * Check given rule.
   *
   * @param port
   * @param ipAddress
   * @return
   */
  public boolean apply(int port, String ipAddress) {
    if (port >= minPort && port <= maxPort) {
      IPAddress ip = new IPAddress(ipAddress);
      if (ip.compareTo(this.minIPAddress) == 0 || ip.compareTo(this.maxIPAddress) == 0 ||
              (ip.compareTo(this.minIPAddress) == 1 && ip.compareTo(this.maxIPAddress) == -1)) {
        return true;
      }
    }
    return false;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public String getProtocol() {
    return protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  public int getMinPort() {
    return minPort;
  }

  public void setMinPort(int minPort) {
    this.minPort = minPort;
  }

  public int getMaxPort() {
    return maxPort;
  }

  public void setMaxPort(int maxPort) {
    this.maxPort = maxPort;
  }

  public IPAddress getMinIPAddress() {
    return minIPAddress;
  }

  public void setMinIPAddress(IPAddress minIPAddress) {
    this.minIPAddress = minIPAddress;
  }

  public IPAddress getMaxIPAddress() {
    return maxIPAddress;
  }

  public void setMaxIPAddress(IPAddress maxIPAddress) {
    this.maxIPAddress = maxIPAddress;
  }

}
