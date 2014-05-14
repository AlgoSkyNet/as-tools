# Get Started

### Download

Download the latest release [here](./download.html)

### Installation

Unzip the distribution and make sure the executable, located under the bin folder, has the proper execution permissions.

### Get help

	excel2as -help

### Import a file

	excel2as import ../examples/jazzfunk.xlsx -header -distribution_role seeder

### Import a spreadsheet

	excel2as import ../examples/jazzfunk.xlsx -sheet album -header -distribution_role seeder

### Import a headerless spreadsheet

	excel2as import ../examples/jazzfunk-noheader.xls -sheet artist -distribution_role seeder -fields "id[LONG key]" "name[STRING]" "birthdate[DATETIME nullable]"

### Export a metaspace

	excel2as export

### Export spaces

	excel2as export artist album