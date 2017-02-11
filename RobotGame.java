package Week3;

interface IBehaviour {
	public int moveCommand();
}

class Attack implements IBehaviour{
	public int moveCommand()
	{
		System.out.println("Attack!");
		return 1;
	}
}

class Defend implements IBehaviour{
	public int moveCommand()
	{
		System.out.println("Defend!");
		return -1;
	}
}

class STC implements IBehaviour{
	public int moveCommand()
	{
		System.out.println("Static!");
		return 0;
	}
}

class Die implements IBehaviour{
	public int moveCommand()
	{
		System.out.println("Died!");
		return -2;
	}
}


class iRobot {
	IBehaviour behaviour;
	String name;

	public iRobot(String name)
	{
		this.name = name;
	}

	public void setBehaviour(IBehaviour behaviour)
	{
		this.behaviour = behaviour;
	}

	public IBehaviour getBehaviour()
	{
		return behaviour;
	}

	public void move()
	{
		int command = behaviour.moveCommand();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}


public class RobotGame {

	public static void main(String[] args) {

		iRobot r1 = new iRobot("Big Robot");
		iRobot r2 = new iRobot("George v.2.1");
		iRobot r3 = new iRobot("R2");

		r1.setBehaviour(new Attack());
		r2.setBehaviour(new Defend());
		r3.setBehaviour(new STC());

		r1.move();
		r2.move();
		r3.move();


		r1.setBehaviour(new Die());
		r2.setBehaviour(new Die());
		r3.setBehaviour(new Defend());

		r1.move();
		r2.move();
		r3.move();
	}
}