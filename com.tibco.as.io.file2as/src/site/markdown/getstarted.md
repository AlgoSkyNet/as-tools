# Get Started

### Download

Download the latest release [here](./download.html)

### Installation

Unzip the distribution and make sure the executable, located under the bin folder, has the proper execution permissions.

### Get help

	file2as -help

### Import a directory

	file2as import ../examples/jazzfunk -header -distribution_role seeder

### Import a headerless file 

	file2as import ../examples/artist.csv -distribution_role seeder -fields "id[LONG key]" "name[STRING]" "birthDate[DATETIME nullable]"

### Export a metaspace

	file2as export

### Export spaces

	file2as export artist album