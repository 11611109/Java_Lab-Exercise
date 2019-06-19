package Assignment;

import java.util.Objects;


public class ChineseChar implements Comparable{
	private final char chinese;
	private final String encode;

    public ChineseChar(char c, String s) {
        chinese = c;
        encode = s;
    }

    public char getChar() {
        return chinese;
    }

    public String getCode() {
        return encode;
    }

    public String toString() {
        return chinese + "," + encode+ ",";
    }

    @Override
    public int hashCode() {
        return Objects.hash(chinese);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
          return false;
        }
        if (o.getClass() == this.getClass()) {
          ChineseChar e = (ChineseChar)o;
          return (this.chinese == e.chinese) ;
        }
        return false;
    }

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if (o instanceof ChineseChar){
			ChineseChar cc=(ChineseChar) o;
			return this.chinese-cc.chinese;
		}
		return 0;
	}
}
