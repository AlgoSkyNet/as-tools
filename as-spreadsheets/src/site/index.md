# Get Started

### Download

Download the latest release <a href="{{site.TDT.site_url}}/nexus/service/local/artifact/maven/redirect?r=snapshots&amp;g=com.tibco.as.io&amp;a=as-spreadsheets&amp;v=1.0.0-SNAPSHOT&amp;e=zip&amp;c=distribution" target="_blank" class="btn btn-primary">spreadsheets-1.0.0</a>
<a href="https://github.com/TIBCOSoftware/as-tools/tree/master/as-spreadsheets" target="_blank" class="btn btn-primary">source code</a>

<a href="https://raw.githubusercontent.com/TIBCOSoftware/as-tools/master/as-spreadsheets/LICENSE.txt?token=7562719__eyJzY29wZSI6IlJhd0Jsb2I6VElCQ09Tb2Z0d2FyZS9hcy10b29scy9tYXN0ZXIvYXMtc3ByZWFkc2hlZXRzL0xJQ0VOU0UudHh0IiwiZXhwaXJlcyI6MTQwMTgzMzgzOX0%3D--761eb6d02620c10f8856d62650d62df276fdf062" target="_blank">Licenses</a>

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
