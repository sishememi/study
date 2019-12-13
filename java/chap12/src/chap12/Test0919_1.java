package chap12;

import java.util.Random;

/*
 * int getRand(f,t): �Լ� �����ϱ�
 * 	f~t �Ǵ� t~f ���� ������ ���ڸ� ������ ���� �����ϴ� �Լ�
 * 	f,t ���� ���Ե�.
 */
public class Test0919_1 {
	static int seed = (int)(Math.random()*1000);
	public static void main(String[] args) {

		for (int i = 0; i < 20; i++) {
			System.out.print(getRand(1, -3) + ",");
		}
		System.out.println();
		for (int i = 0; i < 20; i++) {
			System.out.print(getRand(-1, 3) + ",");
		}

	}

//	static int getRand(int f, int t) {
//		int n = 0;
//		Random rand = new Random();
//
//		if (f > t) {
//			for (int i = t; i <= f; i++) {
//				n = rand.nextInt(f - t + 1) + t;
//			}
//		} else {
//			for (int i = f; i <= t; i++) {
//				n = rand.nextInt(t - f + 1) + f;
//			}
//		}
//		return n;
//	}
	
	static int getRand(int f, int t) {
		int min = Math.min(f, t);
		int max = Math.max(f, t);
		int cha = max - min;
//		return (int)(Math.random()*(cha+1)) + min;
		int seed = (int)(Math.random()*1000);//seed ������ �����
		Random r = new Random();
		r.setSeed(seed);//setSeed = ������ �Ȱ��� ���ڸ� ������ �Ѵ�..
		return r.nextInt(cha+1) + min;
	}
}
