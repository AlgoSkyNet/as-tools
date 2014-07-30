# Configuration


A simulation is described in an XML file in the form:

```xml
<simulation>
	<space name="space1">...</space>
	<space name="space2">...</space>
</simulation> 
```

The simulator will define each space if not already defined, then it will start putting data into the space.  
The `space` element can have the following attributes:
* `name`: name of the space to simulate
* `sleep`: sleep duration in milliseconds between space operations. Default is no sleep.
* `size`: number of tuples to insert in the space. Default is infinity.
* `batchSize`: number of tuples to include in each operation. Default is 1000.
* `distributionRole`: role that the simulator should join the space as. Default is leech.
* `operation`: operation to perform on the space. Default is put.

For example the following configuration: 
```xml
<simulation>
	<space name="People" size="3" sleep="2000" batchSize="1">
		<sequence name="ID" />
		<firstName />
		<lastName />
		<birthDate />
		<address />
		<city />
		<regex name="Phone" regex="[2-9][0-9]{2}-[0-9]{3}-[0-9]{4}" />
		<emailAddress name="Email" />
	</space>
</simulation>
``` 
results in a space named `People` containing 3 tuples, each put every 2 seconds:

| ID                    | FirstName                      | LastName                      | BirthDate                  | Address                      | City                      | Phone                      | Email                         |
|-----------------------|--------------------------------|-------------------------------|----------------------------|------------------------------|---------------------------|----------------------------|-------------------------------|
| 1                     | Gloria                         | Marks                         | 1971-07-11T16:00:00.000    | 568 Maplecraft Crescent      | Axson                     | 638-875-6170               | jriddle@everyma1l.net         |
| 2                     | Lee                            | Holcomb                       | 1968-02-20T16:00:00.000    | 1137 Hartford St             | Milledgeville             | 228-385-5324               | stownsend@yah00.net           |
| 3                     | Charlotte                      | Baker                         | 1967-07-23T16:00:00.000    | 974 Black Path               | Macon                     | 837-813-6375               | lostit@b1zmail.co.uk          |


### Complete Example

```xml
<?xml version="1.0" encoding="UTF-8"?>
<simulation xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:xsd="http://www.w3.org/2001/XMLSchema"
	xsi:noNamespaceSchemaLocation="simulation.xsd">
	<dataValues>
		<addresses>
			<streetName>W Cliff</streetName>
			<streetName>Nautilus</streetName>
			<streetName>Kalakaua</streetName>
			<suffix>Drive</suffix>
			<suffix>Street</suffix>
			<suffix>Avenue</suffix>
			<city>Santa Cruz</city>
			<city>La Jolla</city>
			<city>Honolulu</city>
		</addresses>
		<contents>
			<word>surfboard</word>
			<word>wax</word>
			<word>leash</word>
			<businessType>Surf Shop</businessType>
			<businessType>Fish Market</businessType>
			<businessType>Hotel</businessType>
			<emailHost>gma1l</emailHost>
			<emailHost>hotma1l</emailHost>
			<emailHost>yah00</emailHost>
			<tld>org</tld>
			<tld>net</tld>
			<tld>com</tld>
		</contents>
		<names>
			<firstName>Kelly</firstName>
			<firstName>Rob</firstName>
			<firstName>Joel</firstName>
			<lastName>Slater</lastName>
			<lastName>Machado</lastName>
			<lastName>Tudor</lastName>
			<prefix>Mr</prefix>
			<prefix>Mrs</prefix>
			<prefix>Ms</prefix>
			<suffix>Phd</suffix>
			<suffix>Jr</suffix>
			<suffix>Sr</suffix>
		</names>
	</dataValues>
	<space batchSize="3" distributionRole="seeder" name="people"
		operation="put" size="100" sleep="1000">
		<address />
		<addressLine2 probability="20" />
		<birthDate />
		<blob minSize="10" maxSize="20" />
		<boolean />
		<businessName />
		<city />
		<constant>
			<value xsi:type="xsd:string">value1</value>
		</constant>
		<dateTime dateOnly="false" year="2014" month="11" day="24"
			hour="10" minute="31" second="59" millisecond="123" />
		<dateTime name="DateTime2" start="2014-01-01T12:59:24.321-07:00"
			end="2014-05-30T12:59:24.321-07:00" />
		<double decimals="5" min="123" max="321" />
		<emailAddress />
		<firstName />
		<float />
		<integer min="123" max="321" />
		<item>
			<value xsi:type="xsd:string">Value 1</value>
			<value xsi:type="xsd:string">Value 2</value>
			<value xsi:type="xsd:string">Value 3</value>
		</item>
		<lastName />
		<long />
		<name />
		<now />
		<numberText digits="4" />
		<prefix chance="30" />
		<randomChars case="upper" minLength="5" maxLength="10" />
		<randomChars name="RandomChars2" case="mixed" length="3" />
		<randomText minLength="2" maxLength="10" />
		<randomText name="RandomText2" length="5" />
		<randomWord exactLength="true" length="9" />
		<randomWord name="RandomWord2" minLength="4" maxLength="10" />
		<randomWords exactLength="true" length="12" minCount="2"
			maxCount="4" />
		<randomWords name="RandomWords2" minLength="3" maxLength="10"
			minCount="2" maxCount="4" />
		<regex regex="[2-9][0-9]{2}-[0-9]{3}-[0-9]{4}" />
		<sequence start="1" end="99" />
		<short min="2" max="31" />
		<streetName />
		<streetSuffix />
		<suffix chance="50" />
	</space>
</simulation>
```

### XML Schema

The XML schema for configuration files is available at [simulation.xsd](https://github.com/TIBCOSoftware/as-tools/blob/master/com.tibco.as.io.simulation/src/main/resources/simulation.xsd)
