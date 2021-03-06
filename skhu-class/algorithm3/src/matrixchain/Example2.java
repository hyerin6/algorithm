package matrixchain;

// 중복 호출 확인 
public class Example2 {

	static class Matrix {
		int row, col;

		public Matrix(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static int 곱셈횟수최소값(Matrix[] a, int start, int end) throws Exception {
		if (start == end) return 0;
		System.out.printf("(%d, %d) ", start, end);
		int 최소값 = Integer.MAX_VALUE;
		for (int middle = start; middle < end; ++middle) {
			int 횟수 = 곱셈횟수최소값(a, start, middle);
			횟수 += 곱셈횟수최소값(a, middle + 1, end);
			횟수 += a[start].row * a[middle].col * a[end].col;
			if (횟수 < 최소값) 최소값 = 횟수;
		}
		return 최소값;
	}

	public static void main(String[] args) throws Exception {
		Matrix[] a = new Matrix[] { new Matrix(10, 100), new Matrix(100, 5), new Matrix(5, 50),
				new Matrix(50, 3), new Matrix(3, 8), new Matrix(8, 30) };
		System.out.println(곱셈횟수최소값(a, 0, a.length-1));
	}
}
