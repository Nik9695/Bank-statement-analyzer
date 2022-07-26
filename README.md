<div id="top"></div>

[![Contributors][contributors-shield]][contributors-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
    <img src="src/images/logo.png" alt="Logo" width="650" height="150">

<h2 align="center">Bank statement analyzer</h2>

  <p align="center">
    Project description
    <br/>
    <a href="https://github.com/github_username/repo_name"><strong>Explore the docs »</strong></a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li><a href="#installation">Installation</a></li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#implemented-and-planned-functions">Implemented and planned functions</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project
This project is aimed at developmental independent software designed to analyze banking activity.

Banking Analyzer is not a web resource, which guarantees the protection of each user's personal information, since the results of the program's work are stored only on the local machine.

There are two ways to work with Banking Analyzer:

a) option 'A':

	1) the file under investigation is placed in the specified directory

	2) the program is launched using the Maven plugin

	3) the result is exported to files of 3 different formats - JSON, XML, HTML

b) option 'B':

	1) the program is launched using the Maven plugin, specifying the directory where the file under investigation is located

	2) the result is exported to files of 3 different formats - JSON, XML, HTML

Regardless of the option you choose 'A' or 'B', the results of the program are exported to the folder 'resources'.

In order to get an exact description of how the classes work, please refer to the documentation.
<div align="center">
    <img src="src/images/carbon.png" alt="Logo" width="814" height="658">
</div>

<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

* [Java 8](https://www.oracle.com/java/technologies/java8.html)
* [Apache Maven](https://maven.apache.org/)
* [Junit 4](https://junit.org/junit4/)

<p align="right">(<a href="#top">back to top</a>)</p>


## Installation

1.Clone the repo:
   ```shell
   git clone https://github.com/Nik9695/Bank-statement-analyzer.git
   ```
2.Install MVN packages:
   ```shell
   mvn install
   ```
3.Put file for analyze at:
   ```
   src\main\resources\
   ```
4.Run application:
- using maven plugin `exec` and specifying folder where your 'CSV' file for parsing is located:
   ```shell
    ...\Bank-statement-analyzer>mvn exec:java -Dexec.args="[absolute-file-path]"
   ```
- using maven plugin `exec` without specifying folder dor input. In this case example-file `transactions.txt` will be parsed:
  ```shell
  ...\Bank-statement-analyzer>mvn exec:java 
  ```

In both options export files will be created in next directory :
```shell
...\Bank-statement-analyzer\src\main\resources
```

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

Project is aimed on parsing 'CSV' or 'JSON' files containing information about bank transactions. 

If you want to analyze your bank account activity you can use "Bank statement analyzer" to obtain information in three possible formats:

* HTML
* JSON
* XML

Application using domain object to present you a result of all bank activities presented in your input file ('SummaryStatistics').


You can be sure that all your personal date will not be stored and shared because all manipulations are taking place on your local machine.


_For more examples, please refer to the [Documentation](https://example.com)_

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- Functions -->
## Implemented and planned functions  
- [ ] <b><u>Parsing of input file</u></b>
  - [x] Parsing CSV file
  - [ ] Parsing JSON file
  - [ ] Parsing XML file
- [ ] <b><u>Processing of data</u></b> 
  - [x] Calculating maximum and minimum transaction
  - [x] Calculating average of all transactions
  - [ ] Calculating transactions in specified month
  - [ ] Drawing histogram according to analyzed results
- [x] <b><u>Export</u></b>
  - [x] Export to JSON
  - [x] Export to HTML
  - [x] Export to XML


See the [open issues](https://github.com/Nik9695/Bank-statement-analyzer/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- CONTACT -->
## Contact

Nikita Agureev - nagureev@gmail.com

Project Link: [https://github.com/Nik9695/Bank-statement-analyzer](https://github.com/github_username/repo_name)

<p align="right">(<a href="#top">back to top</a>)</p>




<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[contributors-shield]: https://img.shields.io/github/contributors/Nik9695/Bank-statement-analyzer.svg?style=for-the-badge
[contributors-url]: https://github.com/Nik9695/Bank-statement-analyzer/graphs/contributors

[stars-shield]: https://img.shields.io/github/stars/Nik9695/Bank-statement-analyzer.svg?style=for-the-badge
[stars-url]: https://github.com/Nik9695/Bank-statement-analyzer/stargazers

[issues-shield]: https://img.shields.io/github/issues/Nik9695/Bank-statement-analyzer.svg?style=for-the-badge
[issues-url]: https://github.com/Nik9695/Bank-statement-analyzer/issues


# Bank-statement-analyzer
