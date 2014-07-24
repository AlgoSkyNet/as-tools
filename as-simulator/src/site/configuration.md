# Configuration


A simulation is described in an XML file in the form:

```xml
<simulation metaspace="ms">
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
<simulation metaspace="sim"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema"
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

Here is the schema that configuration files adhere to: 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema">

	<xsd:element name="simulation" type="simulation" />

	<xsd:complexType name="simulation">
		<xsd:sequence>
			<xsd:element name="dataValues" type="dataValues"
				minOccurs="0" />
			<xsd:element name="space" type="space" maxOccurs="unbounded" />
		</xsd:sequence>
		<xsd:attribute name="metaspace" type="xsd:string" />
	</xsd:complexType>

	<xsd:complexType name="space">
		<xsd:choice maxOccurs="unbounded">
			<xsd:element name="blob" type="randomBlob" />
			<xsd:element name="boolean" type="randomBoolean" />
			<xsd:element name="constant" type="constant" />
			<xsd:element name="dateTime" type="randomDateTime" />
			<xsd:element name="double" type="randomDouble" />
			<xsd:element name="float" type="randomFloat" />
			<xsd:element name="integer" type="randomInteger" />
			<xsd:element name="long" type="randomLong" />
			<xsd:element name="short" type="randomShort" />
			<xsd:element name="address" type="address" />
			<xsd:element name="addressLine2" type="addressLine2" />
			<xsd:element name="birthDate" type="birthDate" />
			<xsd:element name="businessName" type="businessName" />
			<xsd:element name="city" type="city" />
			<xsd:element name="emailAddress" type="emailAddress" />
			<xsd:element name="firstName" type="firstName" />
			<xsd:element name="item" type="item" />
			<xsd:element name="lastName" type="lastName" />
			<xsd:element name="name" type="name" />
			<xsd:element name="now" type="now" />
			<xsd:element name="numberText" type="numberText" />
			<xsd:element name="prefix" type="prefix" />
			<xsd:element name="randomChars" type="randomChars" />
			<xsd:element name="randomText" type="randomText" />
			<xsd:element name="randomWord" type="randomWord" />
			<xsd:element name="randomWords" type="randomWords" />
			<xsd:element name="sequence" type="sequence" />
			<xsd:element name="streetName" type="streetName" />
			<xsd:element name="streetSuffix" type="streetSuffix" />
			<xsd:element name="suffix" type="suffix" />
			<xsd:element name="regex" type="regex" />
		</xsd:choice>
		<xsd:attribute name="name" type="xsd:string" use="required" />
		<xsd:attribute name="sleep" type="xsd:long" />
		<xsd:attribute name="size" type="xsd:long" />
		<xsd:attribute name="batchSize" type="xsd:int" />
		<xsd:attribute name="distributionRole" type="distributionRole" />
		<xsd:attribute name="operation" type="operation"
			default="put" />
	</xsd:complexType>

	<xsd:simpleType name="operation">
		<xsd:restriction base="xsd:string">
			<xsd:enumeration value="get" />
			<xsd:enumeration value="load" />
			<xsd:enumeration value="partial" />
			<xsd:enumeration value="put" />
			<xsd:enumeration value="take" />
		</xsd:restriction>
	</xsd:simpleType>

	<xsd:simpleType name="distributionRole">
		<xsd:restriction base="xsd:string">
			<xsd:enumeration value="leech" />
			<xsd:enumeration value="seeder" />
		</xsd:restriction>
	</xsd:simpleType>

	<xsd:complexType name="dataValues">
		<xsd:sequence>
			<xsd:element name="addresses" type="addresses" minOccurs="0" />
			<xsd:element name="contents" type="contents" minOccurs="0" />
			<xsd:element name="names" type="names" minOccurs="0" />
		</xsd:sequence>
	</xsd:complexType>

	<xsd:complexType name="addresses">
		<xsd:sequence>
			<xsd:element name="streetName" type="xsd:string"
				minOccurs="0" maxOccurs="unbounded" />
			<xsd:element name="suffix" type="xsd:string" minOccurs="0"
				maxOccurs="unbounded" />
			<xsd:element name="city" type="xsd:string" minOccurs="0"
				maxOccurs="unbounded" />
		</xsd:sequence>
	</xsd:complexType>

	<xsd:complexType name="contents">
		<xsd:sequence>
			<xsd:element name="word" type="xsd:string" minOccurs="0"
				maxOccurs="unbounded" />
			<xsd:element name="businessType" type="xsd:string"
				minOccurs="0" maxOccurs="unbounded" />
			<xsd:element name="emailHost" type="xsd:string"
				minOccurs="0" maxOccurs="unbounded" />
			<xsd:element name="tld" type="xsd:string" minOccurs="0"
				maxOccurs="unbounded" />
		</xsd:sequence>
	</xsd:complexType>

	<xsd:complexType name="names">
		<xsd:sequence>
			<xsd:element name="firstName" type="xsd:string"
				minOccurs="0" maxOccurs="unbounded" />
			<xsd:element name="lastName" type="xsd:string" minOccurs="0"
				maxOccurs="unbounded" />
			<xsd:element name="prefix" type="xsd:string" minOccurs="0"
				maxOccurs="unbounded" />
			<xsd:element name="suffix" type="xsd:string" minOccurs="0"
				maxOccurs="unbounded" />
		</xsd:sequence>
	</xsd:complexType>

	<xsd:complexType name="simField">
		<xsd:attribute name="name" type="xsd:string" />
		<xsd:attribute name="nullable" type="xsd:boolean"
			default="true" />
		<xsd:attribute name="key" type="xsd:boolean" default="false" />
	</xsd:complexType>

	<xsd:complexType name="constant">
		<xsd:complexContent>
			<xsd:extension base="simField">
				<xsd:sequence>
					<xsd:element name="value" type="xsd:anySimpleType" />
				</xsd:sequence>
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="address">
		<xsd:complexContent>
			<xsd:extension base="simField" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="addressLine2">
		<xsd:complexContent>
			<xsd:extension base="simField">
				<xsd:attribute name="probability" type="xsd:int" />
				<xsd:attribute name="default" type="xsd:string" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="birthDate">
		<xsd:complexContent>
			<xsd:extension base="simField" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="businessName">
		<xsd:complexContent>
			<xsd:extension base="simField" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="city">
		<xsd:complexContent>
			<xsd:extension base="simField" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomDateTime">
		<xsd:complexContent>
			<xsd:extension base="simField">
				<xsd:attribute name="dateOnly" type="xsd:boolean" />
				<xsd:attribute name="year" type="xsd:int" />
				<xsd:attribute name="month" type="xsd:int" default="1" />
				<xsd:attribute name="day" type="xsd:int" default="1" />
				<xsd:attribute name="hour" type="xsd:int" default="0" />
				<xsd:attribute name="minute" type="xsd:int" default="0" />
				<xsd:attribute name="second" type="xsd:int" default="0" />
				<xsd:attribute name="millisecond" type="xsd:int"
					default="0" />
				<xsd:attribute name="start" type="xsd:dateTime" />
				<xsd:attribute name="end" type="xsd:dateTime" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="emailAddress">
		<xsd:complexContent>
			<xsd:extension base="simField" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="firstName">
		<xsd:complexContent>
			<xsd:extension base="simField" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="item">
		<xsd:complexContent>
			<xsd:extension base="simField">
				<xsd:sequence>
					<xsd:element name="default" type="xsd:anySimpleType"
						minOccurs="0" />
					<xsd:element name="value" type="xsd:anySimpleType"
						maxOccurs="unbounded" />
				</xsd:sequence>
				<xsd:attribute name="probability" type="xsd:int" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="lastName">
		<xsd:complexContent>
			<xsd:extension base="simField" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="name">
		<xsd:complexContent>
			<xsd:extension base="simField" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="now">
		<xsd:complexContent>
			<xsd:extension base="simField" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="sequence">
		<xsd:complexContent>
			<xsd:extension base="simField">
				<xsd:attribute name="start" type="xsd:long" default="0" />
				<xsd:attribute name="end" type="xsd:long" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomBlob">
		<xsd:complexContent>
			<xsd:extension base="simField">
				<xsd:attribute name="size" type="xsd:int" />
				<xsd:attribute name="minSize" type="xsd:int" default="0" />
				<xsd:attribute name="maxSize" type="xsd:int" default="100" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomBoolean">
		<xsd:complexContent>
			<xsd:extension base="simField" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomDouble">
		<xsd:complexContent>
			<xsd:extension base="simField">
				<xsd:attribute name="min" type="xsd:double" />
				<xsd:attribute name="max" type="xsd:double" />
				<xsd:attribute name="decimals" type="xsd:int" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomChar">
		<xsd:complexContent>
			<xsd:extension base="simField" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomFloat">
		<xsd:complexContent>
			<xsd:extension base="simField" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomInteger">
		<xsd:complexContent>
			<xsd:extension base="simField">
				<xsd:attribute name="min" type="xsd:int" />
				<xsd:attribute name="max" type="xsd:int" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomLong">
		<xsd:complexContent>
			<xsd:extension base="simField" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomShort">
		<xsd:complexContent>
			<xsd:extension base="simField">
				<xsd:attribute name="min" type="xsd:short" />
				<xsd:attribute name="max" type="xsd:short" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="numberText">
		<xsd:complexContent>
			<xsd:extension base="simField">
				<xsd:attribute name="digits" type="xsd:int" default="10" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="prefix">
		<xsd:complexContent>
			<xsd:extension base="simField">
				<xsd:attribute name="chance" type="xsd:int" default="50" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomChars">
		<xsd:complexContent>
			<xsd:extension base="simField">
				<xsd:attribute name="length" type="xsd:int" />
				<xsd:attribute name="minLength" type="xsd:int"
					default="0" />
				<xsd:attribute name="maxLength" type="xsd:int"
					default="100" />
				<xsd:attribute name="case" type="case" default="mixed" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:simpleType name="case">
		<xsd:restriction base="xsd:string">
			<xsd:enumeration value="mixed" />
			<xsd:enumeration value="lower" />
			<xsd:enumeration value="upper" />
		</xsd:restriction>
	</xsd:simpleType>

	<xsd:complexType name="randomText">
		<xsd:complexContent>
			<xsd:extension base="simField">
				<xsd:attribute name="length" type="xsd:int" />
				<xsd:attribute name="minLength" type="xsd:int"
					default="0" />
				<xsd:attribute name="maxLength" type="xsd:int"
					default="100" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomWord">
		<xsd:complexContent>
			<xsd:extension base="simField">
				<xsd:attribute name="length" type="xsd:int" />
				<xsd:attribute name="minLength" type="xsd:int" />
				<xsd:attribute name="maxLength" type="xsd:int"
					default="10" />
				<xsd:attribute name="exactLength" type="xsd:boolean" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomWords">
		<xsd:complexContent>
			<xsd:extension base="randomWord">
				<xsd:attribute name="minCount" type="xsd:int" default="1" />
				<xsd:attribute name="maxCount" type="xsd:int" default="10" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="streetName">
		<xsd:complexContent>
			<xsd:extension base="simField" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="streetSuffix">
		<xsd:complexContent>
			<xsd:extension base="simField" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="suffix">
		<xsd:complexContent>
			<xsd:extension base="simField">
				<xsd:attribute name="chance" type="xsd:int" default="50" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="regex">
		<xsd:complexContent>
			<xsd:extension base="simField">
				<xsd:attribute name="regex" type="xsd:string" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

</xsd:schema>
```