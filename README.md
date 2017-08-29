# Documentaion of this api
This api is used to validate string for.

1.EmailValidation.

2.EmptyValidation

3.NullValidation

4.RangeValidation

5.SpecialCharacter

## How to use this api

1.First create a string to be validated.
```java
String s = "shivam@gmail.com";```

2.Create a object of above class for example
```java
new EmptyValidation();```

3.Then call validate() method and pass string in it.
```java
 new EmptyValidation.validate(s)```

 4.If you want to validate a string by multiple validator.Then you can pass object of another validator into the constructor of exsting validator for example

 ```java
 new EmptyValidation(new NullValidation()).validate();```

 ```java
 String s = "shivamcs0049@gmail.com";
 IValidationResult validationResult = new EmptyValidation(new NullValidation()).validate(s);
 ```

 6.To print status and message to can do this
 ```java
System.out.println("Status is :"+validationResult.status());
System.out.println("Message is :"+validationResult.message());
  ```

7.IF you want to write your own implementation then you have to implement your class to IValidator  in which you can overriede validate() and return ValidationResult object you can put status pass or fail by using Status.FAIL or Satus.PASS

for example
```java
public IValidationResult validate(Object object) {

  if (this.validator != null) {
    IValidationResult vr = this.validator.validate(object);
    if (vr.status().equals(ValidationResult.Status.FAIL)) {
      return vr;

    }
  }
  Pattern p = Pattern.compile("([0-9])");
  Matcher m = p.matcher((CharSequence) object);
  boolean b = m.find();
  return b == true ? new ValidationResult(Status.FAIL, "Object contains Number.")
      : new ValidationResult(Status.PASS);

}
```
