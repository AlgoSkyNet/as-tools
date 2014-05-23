# Usage

```
Usage: file2as [options] [command] [command options]
  Options:
    -data_store
       Directory path for data store
    -discovery
       Discovery URL
    -?, -help
       Print this help message
    -listen
       Listen URL
    -member_name
       Member name
    -metaspace
       Metaspace name
    -no_exit
       Do not shut down after the Eclipse application has ended
    -rx_buffer_size
       Receive buffer size
    -worker_thread_count
       Worker thread count
  Commands:
    import      Import CSV file(s)
      Usage: import [options] The list of files to import
        Options:
          -batch_size
             Transfer output batch size
          -blob_format
             Blob format (base64, hex)
          -boolean_format
             Boolean format
          -datetime_format
             Date/time format
          -distribution_role
             Distribution role (none, leech, seeder)
          -escape
             Character to use for escaping a separator or quote. Default: no
             escaping
          -fields
             Comma separated fields
             Default: []
          -header
             Treat first line as header containing field names
          -ignore_leading_whitespace
             Ignore white space in front of a quote in a field
          -number_format
             Number format
          -operation
             Space operation (get, load, none, partial, put, take)
          -quote
             Character to use for quoted elements. Default: no quoting
          -separator
             The delimiter to use for separating entries
          -strict_quotes
             Ignore characters outside the quotes
          -wait_for_ready_timeout
             Wait for ready timeout
          -writer_thread_count
             Number of writer threads

    export      Export space(s) to CSV
      Usage: export [options] The list of spaces to export
        Options:
          -batch_size
             Transfer output batch size
          -blob_format
             Blob format (base64, hex)
          -boolean_format
             Boolean format
          -datetime_format
             Date/time format
          -directory
             Export directory. Default: working directory
          -distribution_scope
             Browser distribution scope
          -escape
             Character to use for escaping a separator or quote. Default: none
          -fields
             Comma separated fields
             Default: []
          -filter
             Browser filter
          -no_header
             Do not write a first line containing field names
          -number_format
             Number format
          -prefetch
             Browser prefetch
          -query_limit
             Browser query limit
          -quote
             Character to use for quoted elements. Default: none
          -separator
             The delimiter to use for separating entries
          -time_scope
             Browser time scope
          -timeout
             Browser timeout
          -writer_thread_count
             Number of writer threads
```