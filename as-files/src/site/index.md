# Get Started

### Download

Download the latest release <a href="{{site.TDT.site_url}}/nexus/service/local/artifact/maven/redirect?r=snapshots&amp;g=com.tibco.as.io&amp;a=as-files&amp;v=1.0.0-SNAPSHOT&amp;e=zip&amp;c=distribution" target="_blank" class="btn btn-primary">Delimited Files-1.0.0</a>
<a href="https://github.com/TIBCOSoftware/as-tools/tree/master/as-files" target="_blank" class="btn btn-primary">source code</a>

<a href="https://raw.githubusercontent.com/TIBCOSoftware/as-tools/master/as-files/LICENSE.txt?token=7562719__eyJzY29wZSI6IlJhd0Jsb2I6VElCQ09Tb2Z0d2FyZS9hcy10b29scy9tYXN0ZXIvYXMtZmlsZXMvTElDRU5TRS50eHQiLCJleHBpcmVzIjoxNDAxODMyNTgxfQ%3D%3D--8ac9647123b316eb2031cd0326a25890184e3da2" target="_blank">Licenses</a>

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
