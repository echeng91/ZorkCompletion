import java.util.Scanner;
import java.util.Random;
import java.text.NumberFormat;

public class MainRoom {
	static Scanner darkly = new Scanner(System.in);
	static Random rnd = new Random();
	static NumberFormat currency = NumberFormat.getCurrencyInstance();
	
	static boolean secretRoomFound = false;
	static boolean[] roomVisitedFlag = {false, false, false, false, false, false, false, false};
	static boolean exiting = false;
	//all flags initialized to false
	static int steps = 0;
	static double moneyCollected = 0.00;
	static String thingsSeen = "";

	private static void roomDescribe(String where, String[] stuff, String directions)
	{
		System.out.println("You have " + currency.format(moneyCollected));
		
		System.out.println("You are in " + where);
		for (String thing : stuff) {
			System.out.println("You see " + thing);
		}
		System.out.println("You can go " + directions);
	}

	public static void room1()
	{
		String place = "the Foyer";
		String[] things = new String[1];
		things[0] = "a dead scorpion";
		String direct = "to the north (n) or the south (s)";
		
		steps++;
		if(!roomVisitedFlag[0])
		{
			roomVisitedFlag[0] = true;
			collectMoney();
			noteThingsSeen(things);
		}
		
		do
		{
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("n")) 
			{
				room2();
			}
			else if (choice.equals("s"))
			{
				exit();
			}
			if(exiting)
			{
				break;
			}
		} while (1==1);
	}

	public static void room2()
	{
		String place = "the Front Room";
		String[] things = new String[1];
		things[0] = "a phone";
		String direct = "to the east (e), the south (s) or the west (w)";
		
		steps++;
		if(!roomVisitedFlag[1])
		{
			roomVisitedFlag[1] = true;
			collectMoney();
			noteThingsSeen(things);
		}
		
		do
		{
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("s")) 
			{
				room1();
			} else if (choice.equals("e")) 
			{
				room4();
			} else if (choice.equals("w")) 
			{
				room3();
			}
			if(exiting)
			{
				break;
			}
		} while (1==1);
	}

	public static void room3()
	{
		String place = "the Library";
		String[] things = new String[1];
		things[0] = "spiders";
		String direct = "to the north (n) or the east (e)";
		
		steps++;
		if(!roomVisitedFlag[2])
		{
			roomVisitedFlag[2] = true;
			collectMoney();
			noteThingsSeen(things);
		}
		
		do
		{
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("n")) 
			{
				room5();
			} else if (choice.equals("e")) 
			{
				room2();
			} 
			if(exiting)
			{
				break;
			}
		} while (1==1);
	}

	public static void room4()
	{
		String place = "the Kitchen";
		String[] things = new String[1];
		things[0] = "bats";
		String direct = "to the north (n) or the west (w)";
		
		steps++;
		if(!roomVisitedFlag[3])
		{
			roomVisitedFlag[3] = true;
			collectMoney();
			noteThingsSeen(things);
		}
		
		do
		{
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("n")) 
			{
				room7();
			} else if (choice.equals("w")) 
			{
				room2();
			}
			if(exiting)
			{
				break;
			}
		} while (1==1);
	}

	public static void room5()
	{
		String place = "the Dining Room";
		String[] things = new String[2];
		things[0] = "dust";
		things[1] = "an empty box";
		String direct = "to the south (s)";
		
		steps++;
		if(!roomVisitedFlag[4])
		{
			roomVisitedFlag[4] = true;
			collectMoney();
			noteThingsSeen(things);
		}
		
		do
		{
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("s")) 
			{
				room3();
			}
			if(exiting)
			{
				break;
			}
		} while (1==1);
	}

	public static void room6()
	{
		String place = "the Vault";
		String[] things = new String[1];
		things[0] = "3 walking skeletons";
		String direct = "to the east (e)";
		
		steps++;
		if(!roomVisitedFlag[5])
		{
			roomVisitedFlag[5] = true;
			collectMoney();
			noteThingsSeen(things);
		}
		
		if(!secretRoomFound)
		{
			int discoverRoom = rnd.nextInt(4);
			if(discoverRoom == 0)
			{
				secretRoomFound = true;
			}
		}
		else
		{
			direct += " or to the secret room to the east (x)";
		}

		do
		{
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("e")) 
			{
				room7();
			}
			else if(secretRoomFound && choice.equals("x"))
			{
				room8();
			}
			if(exiting)
			{
				break;
			}
		} while (1==1);
	}

	public static void room7()
	{
		String place = "the Parlor";
		String[] things = new String[1];
		things[0] = "a treasure chest";
		String direct = "to the south (s) or the west (w)";
		
		steps++;
		if(!roomVisitedFlag[6])
		{
			roomVisitedFlag[6] = true;
			collectMoney();
			noteThingsSeen(things);
		}
		
		do
		{
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("s")) 
			{
				room4();
			}
			else if (choice.equals("w")) 
			{
				room6();
			}
			if(exiting)
			{
				break;
			}
		} while (1==1);
	}

	public static void room8()
	{
		String place = "the Secret Room";
		String[] things = new String[1];
		things[0] = "piles of gold";
		String direct = "to the west (w)";
		
		steps++;
		if(!roomVisitedFlag[7])
		{
			roomVisitedFlag[7] = true;
			collectMoney();
			noteThingsSeen(things);
		}
		
		do
		{
			roomDescribe(place, things, direct);

			String choice = darkly.next();

			if (choice.equals("w")) 
			{
				room6();
			}
			if(exiting)
			{
				break;
			}
		} while (1==1);
	}

	public static void exit()
	{
		String place = "the Exit";
		String[] things = new String[1];
		things[0] = "nothing";
		String direct = "nowhere";
		
		roomDescribe(place, things, direct);
		
		int roomsVisited = 0;
		for(int i = 0; i < roomVisitedFlag.length; i++)
		{
			if(roomVisitedFlag[i])
			{
				roomsVisited++;
			}
		}
		System.out.printf("You took %d steps%n", steps);
		System.out.printf("You visited %d rooms%n", roomsVisited);
		System.out.printf("You saw: %n%s", thingsSeen);
		
		int followed = rnd.nextInt(4);
		if(followed == 0)
		{
			System.out.println("The ghost of Zork has followed you out.");
		}
		else
		{
			System.out.println("You were not followed.");
		}
		exiting = true;
	}
	
	public static void collectMoney()
	{
		double moneyInRoom = (double)rnd.nextInt(100000) / 100;
		//Using random integer from 0-100000 divided by 100 to give exactly two decimal places
		System.out.println("You found " + currency.format(moneyInRoom));
		moneyCollected += moneyInRoom;
	}
	
	public static void noteThingsSeen(String[] stuff)
	{
		for (String thing : stuff) {
			thingsSeen += "\t" + thing + "\n";
		}
	}

	public static void main(String[] args) {
		room1();
	}

}