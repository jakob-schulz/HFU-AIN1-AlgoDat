
public abstract class Zahlungsmittel implements Comparable<Zahlungsmittel> {
  private String waehrung;
  private double wert;
  protected Zahlungsmittel(String waehrung, double wert) {
	  this.waehrung = waehrung;
      this.wert = wert;
  }
  public String getWaehrung() {return waehrung;}
  public double getWert() {return wert;}
  public abstract boolean wertIstGueltig();		  

  public String toString() {
    return (wert + " " + waehrung);
  }

	public int compareTo(Zahlungsmittel z) { //Scheine und Münzen werden nach der Zahl, die auf ihnen steht sortiert.
		if(getWert() < z.getWert())
		{
			return -1;
		}
		if(getWert() > z.getWert())
		{
			return 1;
		}
		return 0;
	}
}