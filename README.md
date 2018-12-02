# 设计模式-Java版

## 软件设计原则-面向对象编程设计原则

### 开闭原则
> 定义：一个软件实体（如类，模块和函数）应该对扩展开放，对修改关闭

开闭原则明确的告诉我们：软件实现应该对扩展开放，对修改关闭，其含义是说一个软件应该通过扩展来实现变化，而不是通过修改已有的代码来实现变化的

一个软件产品只要在生命周期内，都会发生变化，即然变化是一个事实，我们就应该在设计时尽量适应这些变化，以提高项目的稳定性和灵活性，真正实现“拥抱变化”。开闭原则告诉我们应尽量通过扩展软件实体的行为来实现变化，而不是通过修改现有代码来完成变化，它是为软件实体的未来事件而制定的对现行开发设计进行约束的一个原则

代码演示什么是开闭原则：
以在线教育课程为例：定义一个销售的课程接口`ICourse`,该接口有一个方法`getPrice()`用于获取课程的价格，有一个课程类JavaCourse实现了课程接口。

现在遇到节日，平台做优惠活动，现在课程打折销售，遇到这样一个场景，应该如何应对呢？

可以想到有下面几种方式：
1. 修改接口`ICourse`,我们最先想到的就是在ICourse接口中添加一个方法返回打折价格：getDiscountPrice()然后再类中实现这个方法，然后在获取价格的时候调用getDiscountPrice方法
2. 修改实现类，直接在getPrice()方法中实现打折处理。此方法是有问题的，例如我们如果getPrice()方法中只需要读取书籍的打折前的价格呢？这不是有问题吗？当然我们也可以再增加getOffPrice()方法，这也是可以实现其需求，但是这就有二个读取价格的方法，因此，该方案也不是一个最优方案。
3. 增加扩展，新建一个基于JavaCourse的子类JavaDiscountCourse，新增方法getDiscountPrice()和getOriginPrice()

部分代码如下：
```java
public interface ICourse {
	Integer getId();
	String getName();
	Double getPrice();
}

```
实现类：
```java
public class JavaCourse implements ICourse{
	private Integer id;
	
	private String name;
	
	private Double price;
	
	public JavaCourse(Integer id,String name,Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public JavaCourse() {}
	
	
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Double getPrice() {
		return price;
	}
	
}
```
打折课程子类JavaDiscountCourse
```java
public class JavaDiscountCourse extends JavaCourse{

	public JavaDiscountCourse(Integer id, String name, Double price) {
		super(id, name, price);
		
	}

	@Override
	public Double getPrice() {
		// 大于200就打折
		if(super.getPrice() > 200) {
			return super.getPrice()*0.8;
		}
		return super.getPrice();
	}
	
	public Double getOriginPrice() {
		return super.getPrice();
	}

}

```

### 依赖倒置原则

> 定义：高层模块不应该依赖底层模块，都应该依赖其抽象抽象不应该依赖于细节，细节应当依赖于抽象。换言之，要针对`抽象（接口）编程`，而不是针对实现细节编程

`开闭原则（OCP）`是面向对象设计原则的基础也是整个设计的一个终极目标，而`依赖倒置原则（DIP )`则是实现`OCP原则`的一个基础，换句话说开闭原则（OCP）是你盖一栋大楼的设计蓝图，
那么依赖倒置原则就是盖这栋大楼的一个钢构框架，没有钢构架构是很难顺利盖起一栋大楼的，
同样的在面向对象软件设计的过程中不遵守依赖倒置原则是很难开发出符合开闭原则的软件的。更不用说开发出易于维护，易于升级的软件。 因此开闭原则是非常重要的一个原则，它有很强的实操性，并且能够直接指导我们写代码代码。

通常要符合这个原则的第一步就是`针对抽象编程`，类之间的依赖关系尽量去使用高层抽象不要使用底层的实现细节，
从软件工程来说高层抽象是较稳定的，也就是说抽象具有一定的稳定性，而实现细节较不稳定，也就是说实现细节具有易变性，
而我们期望软件具有更好的稳定性，显而易见我们在开发的时候自然而然的要走稳定路线（依赖抽象编程）。
这个原则也是对软件工程中要求`高聚低偶`实践一个保障和指导。

> 优点：减少类间的耦合，提高系统稳定性，提高代码可读性，降低程序修改造成的风险

> 面向接口编程

现在有一个`Ranger`类，可以学习各种课程，如Java，前端

我们在高层次的模块中可以调用`Ranger`的方法，如果现在要增加学习`Python`课程，可以直接在`Ranger`类上做修改，增加一个学习`Python`的方法

但是以后如果还需要学习其它课程，就还要修改`Ranger`类的代码，增加新的课程。这样高层次的模块就依赖了低层模块`Ranger`。

现在创建一个接口`ICourse`，接口中定义课程学习方法，以后根据不同的课程来创建不同的课程类并实现`ICourse`接口，实现类对接口中的方法做具体的实现
而`Ranger`这个类中，只需要拥有一个`ICourse`的抽象模块，在学习课程方法中调用抽象模块的方法

简单代码示例：

课程接口
```java
public interface ICourse {
	void studyCourse();

}

```

`Ranger`低层模块
```java
public class Ranger {
	
	private ICourse icourse;
	
	/**
	 * 构造器注入
	 * @param icourse
	 */
	public Ranger(ICourse icourse) {
		this.icourse = icourse;
	}
	
	public Ranger() {}
	public void studyCourse() {
		icourse.studyCourse();
	}
	/**
	 * setter注入
	 * @param icourse
	 */
	public void setiCourse(ICourse icourse) {
		this.icourse = icourse;
	}
	
	
}
```
不同的课程实现类
```java

public class JavaCourse implements ICourse{

	public void studyCourse() {
		System.out.println("学习Java课程");
	}
	
}

public class FECourse implements ICourse{

	
	public void studyCourse() {
		System.out.println("学习 FE 课程");
		
	}

}
```

现在高层模块调用低层模块
```java
public class Test {
	// v1
//	public static void main(String[] args) {
//		Ranger ranger = new Ranger();
//		ranger.studyJavaCourse();
//		ranger.studyFECourse();
//	}
	
	// v2 接口方法注入	
//	public static void main(String[] args) {
//		Ranger ranger = new Ranger();
//		// 构建一个课程内
//		ICourse javaCourse = new JavaCourse();
//		ranger.studyCourse(javaCourse);
//	}
	
	// v3 构造器注入
//	public static void main(String[] args) {
//		Ranger ranger = new Ranger(new JavaCourse());
//		ranger.studyCourse();
//	}
	
	// v4 setter 注入
	public static void main(String[] args) {
		Ranger ranger = new Ranger();
		ranger.setiCourse(new JavaCourse());
		ranger.studyCourse();
	}
}
```

以上就是对于依赖倒置原则的示例，这样设计，以后要增加新的功能，就用扩展的方法而不是修改原有的模块。
这种思想也体现在`Spring`的控制反转，依赖注入中

### 单一职责原则

> 定义：不要存在多于一个导致类变更的原因

解决办法：一个类/接口/方法只负责一项职责

优点：
- 降低类的复杂度
- 提高类的可读性
- 提高系统可维护性
- 降低变更引起的风险

此原则适用于模块化，面向对象编程

示例：

有一个课程接口
```java
public interface ICourse {
	String getCourseName();
	byte[] getCourseVideo();
	
	void studyCourse();
	void refundCourse();
}

```
这个接口中包含了两类操作，一个是与课程信息相关，一个是管理课程相关，这时我们可以把这个接口拆分

```java
public interface ICourseContent {
	String getCourseName();
	byte[] getCourseVideo();
}

public interface ICourseManager {
	void studyCourse();
	void refundCourse();
}
```

类单一化

例如现在有一个Bird类，这个类中有一个表示移动方式的方法

但是不同的鸟有不同的移动方法，有的是用脚，有的用翅膀，如果在这个方法做很多判断，根据不同的鸟来选择不同的移动方式，那这个方法就违背了单一职责

我们可以建立不同的鸟类

```java
public class Bird {
	public void mainMoveModel(String birdName) {
		if("鸵鸟".equals(birdName)) {
			System.out.println(birdName+"用脚走");
			
		}else {
			System.out.println(birdName+"用翅膀飞");
		}
		
	}
}

public class FlyBird {
	public void mainMoveModel(String birdName) {
		System.out.println(birdName+"用翅膀飞");
	}
}

public class WalkBird {
	public void mainMoveModel(String birdName) {
		System.out.println(birdName+"用脚走");
	}
}

```














