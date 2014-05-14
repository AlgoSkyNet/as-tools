# Configuration


Simulations are described in XML files. For example the following configuration: 

```xml
<simulation>
	<space name="people" end="10" distributionRole="seeder">
		<fields>
			<sequence name="id" />
			<firstName />
			<lastName />
			<birthDate name="dob" />
			<address name="address" />
			<city name="city" />
			<regex name="phone" regex="[2-9][0-9]{2}-[0-9]{3}-[0-9]{4}" />
			<emailAddress name="email" />
		</fields>
	</space>
</simulation>
``` 

results in a space named `people` containing 10 tuples:

| ID                    | FirstName                      | LastName                      | BirthDate                  | Address                      | City                      | Phone                      | Email                         |
|-----------------------|--------------------------------|-------------------------------|----------------------------|------------------------------|---------------------------|----------------------------|-------------------------------|
| 1                     | Gloria                         | Marks                         | 1971-07-11T16:00:00.000    | 568 Maplecraft Crescent      | Axson                     | 638-875-6170               | jriddle@everyma1l.net         |
| 2                     | Lee                            | Holcomb                       | 1968-02-20T16:00:00.000    | 1137 Hartford St             | Milledgeville             | 228-385-5324               | stownsend@yah00.net           |
| 3                     | Charlotte                      | Baker                         | 1967-07-23T16:00:00.000    | 974 Black Path               | Macon                     | 837-813-6375               | lostit@b1zmail.co.uk          |
| 4                     | Melody                         | Mayo                          | 1968-01-18T16:00:00.000    | 1419 Tileston Trail          | Riverside                 | 343-175-5033               | jparker@everyma1l.com         |
| 5                     | Kaitlyn                        | Kerr                          | 1975-04-02T16:00:00.000    | 1751 Fairall Boulevard       | Hoboken                   | 621-731-8387               | mbaird@gma1l.biz              |
| 6                     | Jeff                           | Hoover                        | 1964-03-01T16:00:00.000    | 541 Joyce Park               | Abbeville                 | 553-044-8831               | dhowell@yah00.com             |
| 7                     | Kenneth                        | Kirkland                      | 1971-07-13T16:00:00.000    | 1183 Briarcliff Avenue       | Wrightsville              | 678-488-4816               | phorne@gma1l.biz              |
| 8                     | Russ                           | Prince                        | 1973-10-31T16:00:00.000    | 904 Davis St                 | Bremen                    | 812-500-3267               | warpit12@gma1l.net            |
| 9                     | Marty                          | Wilkerson                     | 1984-09-21T16:00:00.000    | 868 Amsterdam Run            | White Oak                 | 338-248-4368               | balvarado@ma1lbox.co.uk       |
| 10                    | Willie                         | Greene                        | 1965-11-13T16:00:00.000    | 1335 Coburg Trail            | Portal                    | 837-528-2867               | computerothers@gma1l.net      |



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
		<xsd:sequence>
			<xsd:choice minOccurs="1">
				<xsd:element name="fields" type="fields" />
				<xsd:element name="browse" type="browse" />
			</xsd:choice>
			<xsd:element name="updates" type="updates" minOccurs="0" />
		</xsd:sequence>
		<xsd:attribute name="name" type="xsd:string" use="required" />
		<xsd:attribute name="sleep" type="xsd:long" />
		<xsd:attribute name="end" type="xsd:long" />
		<xsd:attribute name="batchSize" type="xsd:int" />
		<xsd:attribute name="distributionRole" type="distributionRole" />
	</xsd:complexType>

	<xsd:simpleType name="distributionRole">
		<xsd:restriction base="xsd:string">
			<xsd:enumeration value="leech" />
			<xsd:enumeration value="seeder" />
		</xsd:restriction>
	</xsd:simpleType>

	<xsd:complexType name="browse">
		<xsd:attribute name="filter" type="xsd:string" />
		<xsd:attribute name="type" type="browserType" />
		<xsd:attribute name="distributionScope" type="distributionScope" />
		<xsd:attribute name="prefetch" type="xsd:long" />
		<xsd:attribute name="timeout" type="xsd:long" />
		<xsd:attribute name="timeScope" type="timeScope" />
	</xsd:complexType>

	<xsd:simpleType name="browserType">
		<xsd:restriction base="xsd:string">
			<xsd:enumeration value="get" />
			<xsd:enumeration value="lock" />
			<xsd:enumeration value="take" />
		</xsd:restriction>
	</xsd:simpleType>

	<xsd:simpleType name="distributionScope">
		<xsd:restriction base="xsd:string">
			<xsd:enumeration value="all" />
			<xsd:enumeration value="seeded" />
		</xsd:restriction>
	</xsd:simpleType>

	<xsd:simpleType name="timeScope">
		<xsd:restriction base="xsd:string">
			<xsd:enumeration value="all" />
			<xsd:enumeration value="new" />
			<xsd:enumeration value="snapshot" />
			<xsd:enumeration value="current" />
		</xsd:restriction>
	</xsd:simpleType>

	<xsd:complexType name="fields">
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
			<xsd:element name="browse" type="browseField" />
		</xsd:choice>
	</xsd:complexType>

	<xsd:complexType name="updates">
		<xsd:choice maxOccurs="unbounded">
			<xsd:element name="integer" type="integerUpdate" />
			<xsd:element name="long" type="longUpdate" />
			<xsd:element name="double" type="doubleUpdate" />
			<xsd:element name="short" type="shortUpdate" />
			<xsd:element name="dateTime" type="dateTimeUpdate" />
		</xsd:choice>
	</xsd:complexType>

	<xsd:complexType name="dataValues">
		<xsd:sequence>
			<xsd:element name="address" type="addressDataValues" />
			<xsd:element name="content" type="contentDataValues" />
			<xsd:element name="name" type="nameDataValues" />
		</xsd:sequence>
	</xsd:complexType>

	<xsd:complexType name="addressDataValues">
		<xsd:sequence>
			<xsd:element name="streetNames" minOccurs="0">
				<xsd:complexType>
					<xsd:sequence>
						<xsd:element name="streetName" type="xsd:string"
							maxOccurs="unbounded" />
					</xsd:sequence>
				</xsd:complexType>
			</xsd:element>
			<xsd:element name="cities" minOccurs="0">
				<xsd:complexType>
					<xsd:sequence>
						<xsd:element name="city" type="xsd:string" maxOccurs="unbounded" />
					</xsd:sequence>
				</xsd:complexType>
			</xsd:element>
			<xsd:element name="addressSuffixes">
				<xsd:complexType>
					<xsd:sequence>
						<xsd:element name="addressSuffix" type="xsd:string"
							maxOccurs="unbounded" />
					</xsd:sequence>
				</xsd:complexType>
			</xsd:element>

		</xsd:sequence>
	</xsd:complexType>

	<xsd:complexType name="contentDataValues">
		<xsd:sequence>
			<xsd:element name="words" minOccurs="0">
				<xsd:complexType>
					<xsd:sequence>
						<xsd:element name="word" type="xsd:string" maxOccurs="unbounded" />
					</xsd:sequence>
				</xsd:complexType>
			</xsd:element>
			<xsd:element name="businessTypes" minOccurs="0">
				<xsd:complexType>
					<xsd:sequence>
						<xsd:element name="businessType" type="xsd:string"
							maxOccurs="unbounded" />
					</xsd:sequence>
				</xsd:complexType>
			</xsd:element>
			<xsd:element name="emailHosts">
				<xsd:complexType>
					<xsd:sequence>
						<xsd:element name="emailHost" type="xsd:string"
							maxOccurs="unbounded" />
					</xsd:sequence>
				</xsd:complexType>
			</xsd:element>
			<xsd:element name="tlds">
				<xsd:complexType>
					<xsd:sequence>
						<xsd:element name="tld" type="xsd:string" maxOccurs="unbounded" />
					</xsd:sequence>
				</xsd:complexType>
			</xsd:element>
		</xsd:sequence>
	</xsd:complexType>

	<xsd:complexType name="nameDataValues">
		<xsd:sequence>
			<xsd:element name="firstNames" minOccurs="0">
				<xsd:complexType>
					<xsd:sequence>
						<xsd:element name="firstName" type="xsd:string"
							maxOccurs="unbounded" />
					</xsd:sequence>
				</xsd:complexType>
			</xsd:element>
			<xsd:element name="lastNames" minOccurs="0">
				<xsd:complexType>
					<xsd:sequence>
						<xsd:element name="lastName" type="xsd:string"
							maxOccurs="unbounded" />
					</xsd:sequence>
				</xsd:complexType>
			</xsd:element>
			<xsd:element name="prefixes">
				<xsd:complexType>
					<xsd:sequence>
						<xsd:element name="prefix" type="xsd:string"
							maxOccurs="unbounded" />
					</xsd:sequence>
				</xsd:complexType>
			</xsd:element>
			<xsd:element name="suffixes">
				<xsd:complexType>
					<xsd:sequence>
						<xsd:element name="suffix" type="xsd:string"
							maxOccurs="unbounded" />
					</xsd:sequence>
				</xsd:complexType>
			</xsd:element>
		</xsd:sequence>
	</xsd:complexType>

	<xsd:complexType name="field">
		<xsd:attribute name="name" type="xsd:string" />
		<xsd:attribute name="nullable" type="xsd:boolean"
			default="true" />
		<xsd:attribute name="key" type="xsd:boolean" default="false" />
	</xsd:complexType>

	<xsd:complexType name="constant">
		<xsd:complexContent>
			<xsd:extension base="field">
				<xsd:sequence>
					<xsd:element name="value" type="xsd:anySimpleType" />
				</xsd:sequence>
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="address">
		<xsd:complexContent>
			<xsd:extension base="field" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="addressLine2">
		<xsd:complexContent>
			<xsd:extension base="field">
				<xsd:attribute name="probability" type="xsd:int" />
				<xsd:attribute name="default" type="xsd:string" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="birthDate">
		<xsd:complexContent>
			<xsd:extension base="field" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="businessName">
		<xsd:complexContent>
			<xsd:extension base="field" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="city">
		<xsd:complexContent>
			<xsd:extension base="field" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomDateTime">
		<xsd:complexContent>
			<xsd:extension base="field">
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
			<xsd:extension base="field" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="firstName">
		<xsd:complexContent>
			<xsd:extension base="field" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="item">
		<xsd:complexContent>
			<xsd:extension base="field">
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
			<xsd:extension base="field" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="name">
		<xsd:complexContent>
			<xsd:extension base="field" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="now">
		<xsd:complexContent>
			<xsd:extension base="field" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="sequence">
		<xsd:complexContent>
			<xsd:extension base="field">
				<xsd:attribute name="start" type="xsd:long" default="0" />
				<xsd:attribute name="end" type="xsd:long" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomBlob">
		<xsd:complexContent>
			<xsd:extension base="field">
				<xsd:attribute name="size" type="xsd:int" />
				<xsd:attribute name="minSize" type="xsd:int" default="0" />
				<xsd:attribute name="maxSize" type="xsd:int" default="100" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomBoolean">
		<xsd:complexContent>
			<xsd:extension base="field" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomDouble">
		<xsd:complexContent>
			<xsd:extension base="field">
				<xsd:attribute name="min" type="xsd:double" />
				<xsd:attribute name="max" type="xsd:double" />
				<xsd:attribute name="decimals" type="xsd:int" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomChar">
		<xsd:complexContent>
			<xsd:extension base="field" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomFloat">
		<xsd:complexContent>
			<xsd:extension base="field" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomInteger">
		<xsd:complexContent>
			<xsd:extension base="field">
				<xsd:attribute name="min" type="xsd:int" />
				<xsd:attribute name="max" type="xsd:int" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomLong">
		<xsd:complexContent>
			<xsd:extension base="field" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomShort">
		<xsd:complexContent>
			<xsd:extension base="field">
				<xsd:attribute name="min" type="xsd:short" />
				<xsd:attribute name="max" type="xsd:short" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="numberText">
		<xsd:complexContent>
			<xsd:extension base="field">
				<xsd:attribute name="digits" type="xsd:int" default="10" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="browseField">
		<xsd:complexContent>
			<xsd:extension base="field">
				<xsd:attribute name="space" type="xsd:string" />
				<xsd:attribute name="field" type="xsd:string" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="prefix">
		<xsd:complexContent>
			<xsd:extension base="field">
				<xsd:attribute name="chance" type="xsd:int" default="50" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="randomChars">
		<xsd:complexContent>
			<xsd:extension base="field">
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
			<xsd:extension base="field">
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
			<xsd:extension base="field">
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
			<xsd:extension base="field" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="streetSuffix">
		<xsd:complexContent>
			<xsd:extension base="field" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="suffix">
		<xsd:complexContent>
			<xsd:extension base="field">
				<xsd:attribute name="chance" type="xsd:int" default="50" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="regex">
		<xsd:complexContent>
			<xsd:extension base="field">
				<xsd:attribute name="regex" type="xsd:string" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="updateField">
		<xsd:complexContent>
			<xsd:extension base="field" />
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="integerUpdate">
		<xsd:complexContent>
			<xsd:extension base="updateField">
				<xsd:attribute name="plus" type="xsd:int" />
				<xsd:attribute name="minus" type="xsd:int" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="longUpdate">
		<xsd:complexContent>
			<xsd:extension base="updateField">
				<xsd:attribute name="plus" type="xsd:long" />
				<xsd:attribute name="minus" type="xsd:long" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="shortUpdate">
		<xsd:complexContent>
			<xsd:extension base="updateField">
				<xsd:attribute name="plus" type="xsd:short" />
				<xsd:attribute name="minus" type="xsd:short" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="doubleUpdate">
		<xsd:complexContent>
			<xsd:extension base="updateField">
				<xsd:attribute name="plus" type="xsd:double" />
				<xsd:attribute name="minus" type="xsd:double" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

	<xsd:complexType name="dateTimeUpdate">
		<xsd:complexContent>
			<xsd:extension base="updateField">
				<xsd:attribute name="plus" type="xsd:int" />
				<xsd:attribute name="minus" type="xsd:int" />
			</xsd:extension>
		</xsd:complexContent>
	</xsd:complexType>

</xsd:schema>
```