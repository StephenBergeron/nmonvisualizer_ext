# nmonvisualizer_ext

This project is an extension to the nmonvisualizer project for the processing of nmon output.

It provides bash scripts that wraps the execution of the nmonvisualizer jar.
It also provides a simple clojure project that allow to slice and dice this data for consumption.
That allow to use Matlab/Octave for visualization and analysis. 

## Installation

In order to use this project, you need some NMON data to play with and the nmonvisualizer jar executable.
Typically I clone nmonvisualizer from github in my $HOME/projects directory.
The repos is available here: git@github.com:nmonvisualizer/nmonvisualizer.git

A Clojure development environment with [Leiningen](https://leiningen.org/) 
is used to postprocess the CSV data.

<!-- ## Usage -->

<!-- FIXME: explanation -->

<!--     $ java -jar nmonvisualizer_ext-0.1.0-standalone.jar [args] -->

<!-- ## Options -->

<!-- FIXME: listing of options this app accepts. -->

<!-- ## Examples -->

<!-- ... -->

<!-- ### Bugs -->

<!-- ... -->

<!-- ### Any Other Sections -->
<!-- ### That You Think -->
<!-- ### Might be Useful -->

## License

Source Copyright © 2018 Stephen Bergeron. Distributed under the Eclipse Public License, the same as Clojure uses. 

