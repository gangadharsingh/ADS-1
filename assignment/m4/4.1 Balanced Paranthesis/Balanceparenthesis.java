
class Balanceparenthesis {
	public static boolean checkParanthesis(String str) {
		Linkedlist obj = new Linkedlist();
		int strLength = str.length();
		for (int i = 0; i < strLength; i++) {
			char character = str.charAt(i);
			if (character == '(' || character == '{' || character == '[') {
				obj.push(character);
			}
			else {
				if(obj.isEmpty()) {
					return false;	
				}
				if (character == ')' && obj.topelement() == '(') {
					obj.pop();
				} else if (character == '}' && obj.topelement() == '{') {
					obj.pop();
				} else if (character == ']' && obj.topelement() == '[') {
					obj.pop();
				} else return false;
			}
		}
		return obj.isEmpty();
	}
}
