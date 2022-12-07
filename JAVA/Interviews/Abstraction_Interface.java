
interface Phone {

  int isCallOk();

  int isInternetOk();

}

class Samsung implements Phone {

  @Override
  public int isCallOk() {
    System.out.println("Call OK - Samsung");
    return 0;
  }

  @Override
  public int isInternetOk() {
    System.out.println("Internet OK - Samsung");
    return 0;
  }

}

class Iphone implements Phone {

  @Override
  public int isCallOk() {
    System.out.println("Call OK - Iphone");
    return 0;
  }

  @Override
  public int isInternetOk() {
    System.out.println("Internet OK - Iphone");
    return 0;
  }

}

class RepairPhone {

  private Phone phoneType;

  RepairPhone(Phone phoneType) {
    this.phoneType = phoneType;
    this.phoneType.isCallOk();
  }

}

class Main {
  public static void main(String[] argv) {
    // here Phone interface hide its implementation
    Phone phoneObj1 = new Iphone();
    RepairPhone obj1 = new RepairPhone(phoneObj1);
    Phone phoneObj2 = new Samsung();
    RepairPhone obj2 = new RepairPhone(phoneObj2);

  }
}