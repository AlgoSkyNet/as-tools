# Get Started

### Download

Latest release: <a href="http://activespaces.tibco.com/nexus/service/local/artifact/maven/redirect?r=releases&amp;g=com.tibco.as.io&amp;a=as-spreadsheets&amp;v=LATEST&amp;e=zip&amp;c=distribution" target="_blank" class="btn btn-primary">as-spreadsheets-2.0.0</a>

Development build: <a href="http://activespaces.tibco.com/nexus/service/local/artifact/maven/redirect?r=snapshots&amp;g=com.tibco.as.io&amp;a=as-spreadsheets&amp;v=LATEST&amp;e=zip&amp;c=distribution" target="_blank" class="btn btn-primary">as-spreadsheets-2.0.1-SNAPSHOT</a>

Source: <a href="https://github.com/TIBCOSoftware/as-tools/tree/master/as-spreadsheets" target="_blank">as-spreadsheets</a>

<a href="https://raw.githubusercontent.com/TIBCOSoftware/as-tools/master/as-spreadsheets/LICENSE.txt" target="_blank">Licenses</a>

### Installation

Unzip the distribution and make sure the executable, located under the bin folder, has the proper execution permissions.

### Get help

	as-spreadsheets -help

### Import a file

	as-spreadsheets import ../examples/jazzfunk.xlsx -header -distribution_role seeder

### Import a spreadsheet

	as-spreadsheets import ../examples/jazzfunk.xlsx -sheet album -header -distribution_role seeder

### Import a headerless spreadsheet

	as-spreadsheets import ../examples/jazzfunk-noheader.xls -sheet artist -distribution_role seeder -fields "id[LONG key]" "name[STRING]" "birthdate[DATETIME nullable]"

### Export a metaspace

	as-spreadsheets export

### Export spaces

	as-spreadsheets export artist album
