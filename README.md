## Tasks

1. Create a hello world app.
 - Experiment with string interpolation and concatenation
 - Familiarize yourself with primitives.
2. Create the following data models
 - Person
   - age: Int
   - firstName: String
   - lastName: String
   - pets: Set[Animal]
 - Pet
   - age: Int
   - name: String
   - sound: String (eg. "Woof")
 - Dog
   - age: Int
   - name: String
   - sound: String
 - Werewolf (Half human, half dog)
   - Bonus points for having a model that supports this
   - Remember that a werewolf can have a pet, that is another werewolf
 - Family
   - humans: Set[Person]
   - pets: Set[Animal]
   - members: Set[???] 
     - This is for bonus points
     - contains humans and pets
     - must 
3. Add the following methods to the data models
 - Person
  - name: String (full name)
 - Employee
  - percentageOfLifeWorked
 - Family
  - elderly (Anyone over 65)
  - children (Anyone under 18)
  - adults (Anyone 18-65)
 - Person
   - age: Int
     - Must be at least 18
     - Must not be over 100
   - firstName: String
     - Min 2 characters
     - Max 20 characters
     - Can only contain [a-z]
   - lastName: String
     - Min 2 characters
     - Max 20 characters
     - Can only contain [a-z]
   - pets must be valid
 - Pets
   - Must be a max of 20 years old
   - name is not validated


## Real world example

We want to mess with the data in new_your_names.json

1. Learn how to open it.
 - scala.io.Source.fromFile(String)
2. Use Circe + Lenses to access the data
 - This can uses dynamic dispatch
3. Build up a data model for each name
 - Name
 - Year
 - Ethnicity (of mother)
 - Gender
 - Count
4. Emit this data model as JSON
5. Apply various sorting schemes to the data
 - Sort by name
 - Sort by count
 - Sort by gender
 - Sort by ethnicity
6. Ignoring everything other the count
 - what is the highest count name?
