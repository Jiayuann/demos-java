enum Size{
  SMALL(18.8),  MEDIUM(26.8),  LARGE(32.8),  EXTRA_LARGE(40.8);
  private double value;
  private Size(){
    this(0);
  }
  private Size(double value){
     this.value = value;
  }
  double getValue(){
    return value;
  }
}