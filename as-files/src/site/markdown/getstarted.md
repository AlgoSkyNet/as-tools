# Get Started

### Download

Download the latest release [here](./download.html)

### Installation

Unzip the distribution and make sure the executable, located under the bin folder, has the proper execution permissions.

### Get help

	as-files -help

### Import a directory

	as-files import ../examples/jazzfunk -header -distribution_role seeder

### Import a headerless file 

	as-files import ../examples/artist.csv -distribution_role seeder -fields "id[LONG key]" "name[STRING]" "birthDate[DATETIME nullable]"

### Export a metaspace

	as-files export

### Export spaces

	as-files export artist album