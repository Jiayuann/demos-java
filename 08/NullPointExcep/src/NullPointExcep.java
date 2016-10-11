public class NullPointExcep {
	static Test test;
	public static void main(String[] args) {
		System.out.println(test.talk());
	}
}
class Test {
	public String talk() {
		return "this is a boy";
	}
}
