# Get Started

### Download

Download the latest release [here](./download.html)

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