MediaConverter
==============
[![Build Status](https://travis-ci.org/cshubhamrao/MediaConverter.svg?branch=master)](https://travis-ci.org/cshubhamrao/MediaConverter)

Media Converter is a simple and easy to use media conversion and transcoding app written in Java.
This app makes use of the popular [**__ffmpeg__**](http://ffmpeg.org "FFMpeg Project Homepage") utility. With ffmpeg you can be assured about the quality and versatility of the program.
ffmpeg is the same program which powers many popular applications such as VLC Media Player, Google Chrome, MPlayer etc. This program also makes use of the [Apache Commons Exec API](http://commons.apache.org/proper/commons-exec/)

As you might have guessed, to build this project, you need:
* Netbeans IDE (We use Netbeans IDE 8)
* Java JDK (We've used JDK 7, but JDK 6+ will work)
* ~~Prebuilt binanries of ffmpeg (You can get one from [Zeranoe](http://ffmpeg.zeranoe.com/builds/), or use your own)~~ Now `ffmpeg` executables included in `.jar` itself :smile:. 2ae5d17e49ae02a434d434fb76a69b8537ec8e25 
