
public class Monster extends Card {
   private int Atk;
   private int Def;
public Monster (int Atk,int Def,String name,String discription) {
	super(name,discription);
	this.Atk=Atk;
	this.Def=Def;
}
public int getAtk() {
	return Atk;
}
public void setAtk(int atk) {
	Atk = atk;
}
public int getDef() {
	return Def;
}
public void setDef(int def) {
	Def = def;
}
   
   @Override
   public String toString() {
	   return "Monster: " +getName()
	       + " description :"+getDiscription()
	       +"Atk :" +Atk
	       + "def :" +Def;
	   
	   
   }
   
   
   
   
}
