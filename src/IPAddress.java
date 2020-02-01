public class IPAddress implements Comparable {
  private int[] address;

  public IPAddress(String ip) {
    String[] split = ip.split("\\.");
    int[] ints = new int[split.length];
    for (int i = 0; i < split.length; i++) {
      ints[i] = Integer.parseInt(split[i]);
    }
    this.address = ints;
  }

  public int[] getAddress() {
    return address;
  }

  public void setAddress(int[] address) {
    this.address = address;
  }

  @Override
  public int compareTo(Object o2) {
    int[] a2 = ((IPAddress) o2).getAddress();
    for (int i = 0; i < this.address.length; i++) {
      if (this.address[i] == a2[i]) {
        continue;
      }
      if (this.address[i] < a2[i]) {
        return -1;
      } else {
        return 1;
      }
    }
    return 0;
  }
}
