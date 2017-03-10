/**
 * Created by sam on 1/9/17.
 */
public class XMLParserTest {

    // this will test a few xml files
    // take an xml file, parse to json, output to file
    // take an optional second parameter which is a json file that explains the hierarchy of the xml
    // a few tests with second parameter, a few without (how does it work without understanding the hierarchy


    // the algo has an underlying parser that does two things:
    /*
        1. reads a text file, understands new lines(maybe strips them out) and trims the file to the first tag
        2. with each tag, denoted by <.*>, finds closing tag </.*>, or finds closing tag of a different tag
            a. with its own closing tag, creates object with tag as prop name, and
                i. string contents as value // <tag>contents</tag>
                ii. or restarts parser at new tag // <tag><tag2>stuff</tag2></tag>
            b. with closing tag of different tag // <tag>...</tag>...<tag2>...</tag2>
                i. goes from tag to tag2, makes objects and restarts parser to recurse each closing/then/opening tag including open tag2

        then the algo outputs that to json, formatted nicely? what is true json?

     */

}
