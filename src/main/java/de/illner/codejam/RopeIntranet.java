package de.illner.codejam;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class RopeIntranet implements ICodejam {
	
	public static final String IN_SMALL = "A-small-practice.in";
	public static final String OUT_SMALL = "A-small-practice.out";
	public static final String IN_LARGE = "A-large-practice.in";
	public static final String OUT_LARGE = "A-large-practice.out";
	
	public static void main(String[] args) throws FileNotFoundException {
		RopeIntranet ropeIntranet = new RopeIntranet();
		ropeIntranet.solve(RopeIntranet.class, IN_LARGE, OUT_LARGE);
		System.out.println("Finished successfully!");
	}

	@Override
	public void solve(Class<?> caller, String inFile, String outFile) throws FileNotFoundException {
		IoHelperForCodejam ioHelper = new IoHelperForCodejam(caller, inFile, outFile);

		int cntTests = Integer.parseInt(ioHelper.getScanner().nextLine());
		for (int i = 0; i < cntTests; i++)
		{
			int cntWires = Integer.parseInt(ioHelper.getScanner().nextLine());
			List<Integer> left = new ArrayList<>(cntWires);
			List<Integer> right = new ArrayList<>(cntWires);
			
			for (int a = 0; a < cntWires; a++)
			{
				String[] wire = ioHelper.getScanner().nextLine().split(" ");
				assert(wire.length == 2);
				left.add(Integer.valueOf(wire[0]));
				right.add(Integer.valueOf(wire[1]));
			}
			
			ioHelper.printLineWithWriter("Case #" + (i+1) + ": " + countInresects(left, right));
		}
		
		ioHelper.closeScanner();
		ioHelper.closeWriter();
	}

	private int countInresects(List<Integer> left, List<Integer> right) {
		int cntIntersect = 0;
		
		for (int w = 0; w < left.size() - 1; w++)
		{
			for(int n = w + 1; n < left.size(); n++)
			{
				if ((left.get(w).compareTo(left.get(n)) == 1) && (right.get(w).compareTo(right.get(n)) == -1))
				{
					cntIntersect++;
				}
				else if ((left.get(w).compareTo(left.get(n)) == -1) && (right.get(w).compareTo(right.get(n)) == 1))
				{
					cntIntersect++;
				}
			}
		}
		return cntIntersect;
	}

}
