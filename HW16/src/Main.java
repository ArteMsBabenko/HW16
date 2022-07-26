
import java.lang.reflect.*;

public class Main {
	
	public static void main(String[] args)  throws NoSuchMethodException, SecurityException, InstantiationException,
	IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
	Class commodity = Commodity.class;
	
	System.out.println("Class name: " + commodity.getName());
	System.out.println("Simple class name: " + commodity.getSimpleName());
	System.out.println("Class access modifier: " + Modifier.toString(commodity.getModifiers()));
	System.out.println("Current class package: " + commodity.getPackage());
	System.out.println("Main class:: " + commodity.getSuperclass());
	System.out.println();

	System.out.println("Class " + commodity.getSimpleName() + "has the following set of fields: ");
	Field[] commodityFields = commodity.getDeclaredFields();
	for (Field field : commodityFields) {
		System.out.println("Field " + field);
	}
	System.out
			.println("Total number of all fields of the class" + commodity.getSimpleName() + " - " + commodityFields.length);
	System.out.println();

	System.out.println("Class " + commodity.getSimpleName() + " has the following set of public fields: ");
	Field[] commodityPublicFields = commodity.getFields();
	for (Field field : commodityPublicFields) {
		System.out.println("Field " + field);
	}
	System.out.println("Total number of public class fields " + commodity.getSimpleName() + " - " + commodityPublicFields.length);
	System.out.println();

	System.out.println("Class " + commodity.getSimpleName() + " has the following set of constructors: ");
	Constructor[] commodityConstructors = commodity.getConstructors();
	for (Constructor constructor : commodityConstructors) {
		System.out.println("Constructor " + constructor);
	}
	System.out.println("Total number of class constructors " + commodity.getSimpleName() + " - " + commodityConstructors.length);
	System.out.println();

	System.out.println("Class " + commodity.getSimpleName() + " has the following set of methods: ");
	Method[] commodityMethods = commodity.getMethods();
	for (Method method : commodityMethods) {
		System.out.println("Method " + method);
	}
	System.out.println("Total number of class methods " + commodity.getSimpleName() + " - " + commodityMethods.length);
	System.out.println();

	System.out.println("Let's add a new product using reflection:");
	Constructor<Commodity> constructor = commodity.getConstructor(String.class, int.class, int.class);
	Commodity newInstance = constructor.newInstance("Коробка", 25, 50);
	System.out.println(newInstance);
	System.out.println();

	System.out.println("Let's change the product name using reflection:");
	Field fieldName = commodity.getField("name");
	fieldName.set(newInstance, "big box");
	System.out.println(newInstance);
	System.out.println();

	System.out.println("Let's add weight to the product using reflection:");
	Method commodityMethod = commodity.getMethod("setWeight", int.class);
	commodityMethod.invoke(newInstance, 49);
	System.out.println(newInstance);
	System.out.println();

	System.out.println("Let's output the product name to the console using reflection:");
	commodityMethod = commodity.getMethod("getName", null);
	System.out.println("Name of the selected product - " + commodityMethod.invoke(newInstance, null));
	System.out.println();

	System.out.println("Place the product on the specified shelf using reflection:");
	commodityMethod = commodity.getMethod("putOnShelf", int.class);
	commodityMethod.invoke(newInstance, 23);
	System.out.println();

	System.out.println("Let's transfer the goods to the specified person for storage using reflection:");
	commodityMethod = commodity.getMethod("giveForSafekeeping", String.class);
	commodityMethod.invoke(newInstance, "Bander S.A.");
		
		
	}

}
