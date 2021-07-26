## 디자인 패턴

### Adapter 패턴
이미 제공 되어 있는 것을 그대로 사용할 수 없을 때, 필요한 형태로 교환하고 사용하는 일이 자주 있습니다. 
'이미 제공되어 있는 것' 과 '필요한 것' 사이의 '차이' 를 없애주는 디자인 패턴이 Adapter 패턴 입니다.

### Banner 클래스
``` 
package adapter;

public class Banner {
	private String string;
	public Banner(String string) {
		this.string = string;
	}
	public void showWithParen() {
		System.out.println("(" + string + ")");
	}
	public void showWithAster() {
		System.out.println("*" + string + "*");
	}
}
```

### print 인터페이스
```
package adapter;

public interface Print {
	public abstract void pringWeak();
	public abstract void printStrong();
}

```
### PrintBanner 클래스
```
package adapter;

public class PrintBanner extends Banner implements Print{

	public PrintBanner(String string) {
		super(string);
	}

	@Override
	public void pringWeak() {
		showWithParen();
		
	}

	@Override
	public void printStrong() {
		showWithAster();
		
	}
	
}

```
PrintBanner 클래스가 **어댑터**의 역할을 합니다. Banner클래스를 
확장해서 메소드를 상속하고, Print 인터페이스를 구현해서 메소드를 구현하고 있습니다.

### Main클래스
```
package adapter;

public class Main {
	public static void main(String[] args) {
		Print p = new PrintBanner("Hello");
		p.pringWeak();
		p.printStrong();
	}
}
```
**실행 결과**
<img src="https://user-images.githubusercontent.com/87972598/126967914-91239b83-b8c2-4227-8d22-77a8b9d20fb0.png" width="250" height="200">

***Main 클래스 내에서는 PrintBanner의 인스턴스를 Print 인터페이스형의 번수로 대입한것에 주의해야 합니다. 이 Main클래스는 어디까지나 Print라는 인터페이스를
사용하여 프로그래밍을 하고 있습니다. Banner클래스나 showWithParen 메소드, showWithAster 메소드를 Main 메소드에서 환전희 감추어져 있습니다. 
그러므로 Main클래스를 전혀 변경하지 않고 PrintBanner 클래스의 구현을 바꿀수 도 있습니다.***
