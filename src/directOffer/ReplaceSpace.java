package directOffer;


//请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
public class ReplaceSpace {
	public String replaceSpace(StringBuffer str) {
		

		if (str == null) {
			return null;
		}
		int length = str.length();
		
		int numOfBlank = 0;
		
		for (int i = 0; i < length; i++){
			if (str.charAt(i) == ' ') {
				numOfBlank++;
			}
		}
		int newLength = length + 2 * numOfBlank;
		int indexOfNew = newLength - 1;
		int indexOfOld = length - 1;
		str.setLength(newLength);
		for (; indexOfOld >=0; --indexOfOld ) {
			if (str.charAt(indexOfOld) == ' ') {
				str.setCharAt(indexOfNew--, '0');
				str.setCharAt(indexOfNew--,'2');
				str.setCharAt(indexOfNew--, '%');
			} else {
				str.setCharAt(indexOfNew--,str.charAt(indexOfOld));
			}
		}
		return str.toString();
		
	}
}
