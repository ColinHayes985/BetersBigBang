import java.util.Random;

public class Colin extends Game{
    public static char[][] maze = new char[12][8];

    public Colin() {

    }

    private int x = 0;
    private int y = 0;
    Random r = new Random();
    private int z = 1 + r.nextInt(6);               //1 - 6

    public void makeMaze() {
        for (x = 0; x < 8; x++) {

            maze[0][x]='?';                 //borders
            maze[11][x]='/';
            x++;
        }
        for(y=0;y<=11;y++)
        {
            maze[y][0]='/';                 //borders
            maze[y][7]='/';
        }
        for (y=1; y<10; y++)
        {
            for(x=1;x<7; x++)
            {
                maze[y][x]='?';             //fill room with ?s
            }
        }

        for(x=1;x<7; x++) {
            maze[10][x]='t';
        }

        maze[11][4]='D';
        //maze[0][3]="W";
        int a=9;
        int lastMove=5;
        maze[a][z] = 't';
        while (a>=1)
        {
            int moveSwitch=r.nextInt(3);
            switch (moveSwitch)
            {
                case 0:
                    if (z==1)
                    {
                        continue;
                    }
                    else if (lastMove==3)
                    {
                        continue;
                    }
                    else
                    {
                        maze[a][z-1]='t';
                        z-=1;
                        lastMove=1;
                    }
                    break;
                case 1:
                    maze[a-1][z]='t';
                    a-=1;
                    lastMove=1;
                    break;
                case 2:
                    if (z==6)
                    {
                        continue;
                    }
                    else if (lastMove==1)
                    {
                        continue;
                    }
                    else
                    {
                        maze[a][z+1]='t';
                        z+=1;
                        lastMove=3;
                    }
                    break;
            }
        }
			/* -- TEST PRINT
			for (x=0; x<12; x++) {
				for (y = 0; y < 8; y++) {
					System.out.print(maze[x][y]);
				}
				System.out.println("");
			}
			*/
    }
}
