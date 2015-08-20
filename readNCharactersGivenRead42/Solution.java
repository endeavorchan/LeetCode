package readNCharactersGivenRead42;



public class Solution extends Reader4 {
	public int read(char[] buf, int n) {
		char[] buffer = new char[4];
		int readBytes = 0;
		boolean eof = false;
		if (n <= 0 )
			return 0;
		while(!eof && readBytes < n) {
			int sz = read4(buffer);
			if (sz < 4) eof = true;
			int bytes = Math.min(n - readBytes, sz);
			System.arraycopy(buffer, 0, buf, readBytes, bytes);
			readBytes += bytes;
		}
		
		return readBytes;
	}
}
class Reader4 {
	public int read4(char[] buf) {
		return 0;
	}
}