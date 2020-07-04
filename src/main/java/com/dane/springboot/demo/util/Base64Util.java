package com.dane.springboot.demo.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Base64Util {

    public static String image = "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAYEBQYFBAYGBQYHBwYIChAKCgkJChQODwwQFxQYGBcU\n" +
            "FhYaHSUfGhsjHBYWICwgIyYnKSopGR8tMC0oMCUoKSj/2wBDAQcHBwoIChMKChMoGhYaKCgoKCgo\n" +
            "KCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCj/wAARCAHgAoADASIA\n" +
            "AhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA\n" +
            "AAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3\n" +
            "ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm\n" +
            "p6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA\n" +
            "AwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx\n" +
            "BhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK\n" +
            "U1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3\n" +
            "uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD5fooo\n" +
            "oAKKKKACiiigD234b/8AIlaf/wBtP/RjV0lc38N/+RK0/wD7af8Aoxq6SgAooooAKKKKACiiigDx\n" +
            "P4jf8jpqP/bP/wBFrXNV0vxG/wCR01H/ALZ/+i1rmqACiiigAooooAKKKKAPbfhv/wAiVp//AG0/\n" +
            "9GNXSVzfw3/5ErT/APtp/wCjGrpKACiiigAooooAKKKKAPE/iN/yOmo/9s//AEWtc1XS/Eb/AJHT\n" +
            "Uf8Atn/6LWuaoAKKKKACiiigAooooA9t+G//ACJWn/8AbT/0Y1dJXN/Df/kStP8A+2n/AKMaukoA\n" +
            "KKKKACiiigAooooA8T+I3/I6aj/2z/8ARa1zVdL8Rv8AkdNR/wC2f/ota5qgAooooAKKKKACiiig\n" +
            "D234b/8AIlaf/wBtP/RjV0lc38N/+RK0/wD7af8Aoxq6SgAooooAKKKKACiiigDxP4jf8jpqP/bP\n" +
            "/wBFrXNV0vxG/wCR01H/ALZ/+i1rmqACiiigAooooAKKKKAPbfhv/wAiVp//AG0/9GNXSVzfw3/5\n" +
            "ErT/APtp/wCjGrpKACiiigAooooAKKKKAPE/iN/yOmo/9s//AEWtc1XS/Eb/AJHTUf8Atn/6LWua\n" +
            "oAKKKKACiiigAooooA9t+G//ACJWn/8AbT/0Y1dJXN/Df/kStP8A+2n/AKMaukoAKKKKACiiigAo\n" +
            "oooA8T+I3/I6aj/2z/8ARa1zVdL8Rv8AkdNR/wC2f/ota5qgAooooAKKKKACiiigD234b/8AIlaf\n" +
            "/wBtP/RjV0lc38N/+RK0/wD7af8Aoxq6SgAooooAKKKKACiiigDxP4jf8jpqP/bP/wBFrXNV0vxG\n" +
            "/wCR01H/ALZ/+i1rmqACiiigAooooAKKKKAPbfhv/wAiVp//AG0/9GNXSVzfw3/5ErT/APtp/wCj\n" +
            "GrpKACiiigAooooAKKKKAPE/iN/yOmo/9s//AEWtc1XS/Eb/AJHTUf8Atn/6LWuaoAKKKKACiiig\n" +
            "AooooA9t+G//ACJWn/8AbT/0Y1dJXN/Df/kStP8A+2n/AKMaukoAKKKKACiiigAooooA8T+I3/I6\n" +
            "aj/2z/8ARa1zVdL8Rv8AkdNR/wC2f/ota5qgAooooAKKKKACiiigD234b/8AIlaf/wBtP/RjV0lc\n" +
            "38N/+RK0/wD7af8Aoxq6SgAooooAKKKKACiiigDxP4jf8jpqP/bP/wBFrXNV0vxG/wCR01H/ALZ/\n" +
            "+i1rmqACiiigAooooAKKKKAPbfhv/wAiVp//AG0/9GNXSVzfw3/5ErT/APtp/wCjGrpKACiiigAo\n" +
            "oooAKKKKAPE/iN/yOmo/9s//AEWtc1XS/Eb/AJHTUf8Atn/6LWuaoAKKKKACiiigAooooA9t+G//\n" +
            "ACJWn/8AbT/0Y1dJXN/Df/kStP8A+2n/AKMaukoAKKKKACiiigAooooA8T+I3/I6aj/2z/8ARa1z\n" +
            "VdL8Rv8AkdNR/wC2f/ota5qgAooooAKKKKACiiigD234b/8AIlaf/wBtP/RjV0lc38N/+RK0/wD7\n" +
            "af8Aoxq6SgAooooAKKKKACiiigDxP4jf8jpqP/bP/wBFrXNV0vxG/wCR01H/ALZ/+i1rmqACiiig\n" +
            "AooooAKKKKAPbfhv/wAiVp//AG0/9GNXSVzfw3/5ErT/APtp/wCjGrpKACiiigAooooAKKKKAPE/\n" +
            "iN/yOmo/9s//AEWtc1XS/Eb/AJHTUf8Atn/6LWuaoAKKKKACiiigAooooA9t+G//ACJWn/8AbT/0\n" +
            "Y1dJXN/Df/kStP8A+2n/AKMaukoAKKKKACiiigAooooA8T+I3/I6aj/2z/8ARa1zVdL8Rv8AkdNR\n" +
            "/wC2f/ota5qgAor0n/hV/wD1Gf8AyW/+zo/4Vf8A9Rn/AMlv/s6APNqK9J/4Vf8A9Rn/AMlv/s6P\n" +
            "+FX/APUZ/wDJb/7OgDzaivSf+FX/APUZ/wDJb/7Oj/hV/wD1Gf8AyW/+zoA6T4b/APIlaf8A9tP/\n" +
            "AEY1dJXm48Uf8IX/AMU/9j+2/ZP+W/m+Xu3/AD/dwcfex1PSj/haH/UG/wDJn/7CgD0iivN/+Fof\n" +
            "9Qb/AMmf/sKP+Fof9Qb/AMmf/sKAPSKK83/4Wh/1Bv8AyZ/+wo/4Wh/1Bv8AyZ/+woA9Iorzf/ha\n" +
            "H/UG/wDJn/7Cj/haH/UG/wDJn/7CgDm/iN/yOmo/9s//AEWtc1XpI8L/APCaf8T/AO2fYvtf/LDy\n" +
            "vM2bPk+9kZztz070f8Kv/wCoz/5Lf/Z0AebUV6T/AMKv/wCoz/5Lf/Z0f8Kv/wCoz/5Lf/Z0AebU\n" +
            "V6T/AMKv/wCoz/5Lf/Z0f8Kv/wCoz/5Lf/Z0AebUV6T/AMKv/wCoz/5Lf/Z0f8Kv/wCoz/5Lf/Z0\n" +
            "AdJ8N/8AkStP/wC2n/oxq6SvNx4o/wCEL/4p/wCx/bfsn/LfzfL3b/n+7g4+9jqelH/C0P8AqDf+\n" +
            "TP8A9hQB6RRXm/8AwtD/AKg3/kz/APYUf8LQ/wCoN/5M/wD2FAHpFFeb/wDC0P8AqDf+TP8A9hR/\n" +
            "wtD/AKg3/kz/APYUAekUV5v/AMLQ/wCoN/5M/wD2FH/C0P8AqDf+TP8A9hQBzfxG/wCR01H/ALZ/\n" +
            "+i1rmq9JHhf/AITT/if/AGz7F9r/AOWHleZs2fJ97Iznbnp3o/4Vf/1Gf/Jb/wCzoA82or0n/hV/\n" +
            "/UZ/8lv/ALOj/hV//UZ/8lv/ALOgDzaivSf+FX/9Rn/yW/8As6P+FX/9Rn/yW/8As6APNqK9J/4V\n" +
            "f/1Gf/Jb/wCzo/4Vf/1Gf/Jb/wCzoA6T4b/8iVp//bT/ANGNXSV5uPFH/CF/8U/9j+2/ZP8Alv5v\n" +
            "l7t/z/dwcfex1PSj/haH/UG/8mf/ALCgD0iivN/+Fof9Qb/yZ/8AsKP+Fof9Qb/yZ/8AsKAPSKK8\n" +
            "3/4Wh/1Bv/Jn/wCwo/4Wh/1Bv/Jn/wCwoA9Iorzf/haH/UG/8mf/ALCj/haH/UG/8mf/ALCgDm/i\n" +
            "N/yOmo/9s/8A0Wtc1XpI8L/8Jp/xP/tn2L7X/wAsPK8zZs+T72RnO3PTvR/wq/8A6jP/AJLf/Z0A\n" +
            "ebUV6T/wq/8A6jP/AJLf/Z0f8Kv/AOoz/wCS3/2dAHm1Fek/8Kv/AOoz/wCS3/2dH/Cr/wDqM/8A\n" +
            "kt/9nQB5tRXpP/Cr/wDqM/8Akt/9nR/wq/8A6jP/AJLf/Z0AdJ8N/wDkStP/AO2n/oxq6SvNx4o/\n" +
            "4Qv/AIp/7H9t+yf8t/N8vdv+f7uDj72Op6Uf8LQ/6g3/AJM//YUAekUV5v8A8LQ/6g3/AJM//YUf\n" +
            "8LQ/6g3/AJM//YUAekUV5v8A8LQ/6g3/AJM//YUf8LQ/6g3/AJM//YUAekUV5v8A8LQ/6g3/AJM/\n" +
            "/YUf8LQ/6g3/AJM//YUAc38Rv+R01H/tn/6LWuar0keF/wDhNP8Aif8A2z7F9r/5YeV5mzZ8n3sj\n" +
            "Oduenej/AIVf/wBRn/yW/wDs6APNqK9J/wCFX/8AUZ/8lv8A7Oj/AIVf/wBRn/yW/wDs6APNqK9J\n" +
            "/wCFX/8AUZ/8lv8A7Oj/AIVf/wBRn/yW/wDs6APNqK9J/wCFX/8AUZ/8lv8A7Oj/AIVf/wBRn/yW\n" +
            "/wDs6AOk+G//ACJWn/8AbT/0Y1dJXm48Uf8ACF/8U/8AY/tv2T/lv5vl7t/z/dwcfex1PSj/AIWh\n" +
            "/wBQb/yZ/wDsKAPSKK83/wCFof8AUG/8mf8A7Cj/AIWh/wBQb/yZ/wDsKAPSKK83/wCFof8AUG/8\n" +
            "mf8A7Cj/AIWh/wBQb/yZ/wDsKAPSKK83/wCFof8AUG/8mf8A7Cj/AIWh/wBQb/yZ/wDsKAOb+I3/\n" +
            "ACOmo/8AbP8A9FrXNV6SPC//AAmn/E/+2fYvtf8Ayw8rzNmz5PvZGc7c9O9H/Cr/APqM/wDkt/8A\n" +
            "Z0AekUUUUAFFFFABRRRQB4n8Rv8AkdNR/wC2f/ota5qul+I3/I6aj/2z/wDRa1zVABRRRQAUUUUA\n" +
            "FFFFAHtvw3/5ErT/APtp/wCjGrpK5v4b/wDIlaf/ANtP/RjV0lABRRRQAUUUUAFFFFAHifxG/wCR\n" +
            "01H/ALZ/+i1rmq6X4jf8jpqP/bP/ANFrXNUAFFFFABRRRQAUUUUAe2/Df/kStP8A+2n/AKMaukrm\n" +
            "/hv/AMiVp/8A20/9GNXSUAFFFFABRRRQAUUUUAeJ/Eb/AJHTUf8Atn/6LWuarpfiN/yOmo/9s/8A\n" +
            "0Wtc1QAUUUUAFFFFABRRRQB7b8N/+RK0/wD7af8Aoxq6Sub+G/8AyJWn/wDbT/0Y1dJQAUUUUAFF\n" +
            "FFABRRRQB4n8Rv8AkdNR/wC2f/ota5qul+I3/I6aj/2z/wDRa1zVABRRRQAUUUUAFFFFAHtvw3/5\n" +
            "ErT/APtp/wCjGrpK5v4b/wDIlaf/ANtP/RjV0lABRRRQAUUUUAFFFFAHifxG/wCR01H/ALZ/+i1r\n" +
            "mq6X4jf8jpqP/bP/ANFrXNUAFFFFABRRRQAUUUUAe2/Df/kStP8A+2n/AKMaukrm/hv/AMiVp/8A\n" +
            "20/9GNXSUAFFFFABRRRQAUUUUAeJ/Eb/AJHTUf8Atn/6LWuarpfiN/yOmo/9s/8A0Wtc1QAUUUUA\n" +
            "FFFFABRRRQB7b8N/+RK0/wD7af8Aoxq6Sub+G/8AyJWn/wDbT/0Y1dJQAUUUUAFFFFABRRRQB4n8\n" +
            "Rv8AkdNR/wC2f/ota5qul+I3/I6aj/2z/wDRa1zVABRRRQAUUUUAFFFFAHtvw3/5ErT/APtp/wCj\n" +
            "GrpK5v4b/wDIlaf/ANtP/RjV0lABRRRQAUUUUAFFFFAHifxG/wCR01H/ALZ/+i1rmq6X4jf8jpqP\n" +
            "/bP/ANFrXNUAFFFFABRRRQAUUUUAe2/Df/kStP8A+2n/AKMaukrm/hv/AMiVp/8A20/9GNXSUAFF\n" +
            "FFABRRRQAUUUUAeJ/Eb/AJHTUf8Atn/6LWuarpfiN/yOmo/9s/8A0Wtc1QAUUUUAFFFFABRRRQB7\n" +
            "b8N/+RK0/wD7af8Aoxq6Sub+G/8AyJWn/wDbT/0Y1dJQAUUUUAFFFFABRRRQB4n8Rv8AkdNR/wC2\n" +
            "f/ota5qul+I3/I6aj/2z/wDRa1zVABRRRQAUUUUAFFFFAHtvw3/5ErT/APtp/wCjGrpK5v4b/wDI\n" +
            "laf/ANtP/RjV0lABRRRQAUUUUAFFFFAHifxG/wCR01H/ALZ/+i1rmq6X4jf8jpqP/bP/ANFrXNUA\n" +
            "FFFFABRRRQAUUUUAe2/Df/kStP8A+2n/AKMaukrm/hv/AMiVp/8A20/9GNXSUAFFFFABRRRQAUUU\n" +
            "UAeJ/Eb/AJHTUf8Atn/6LWuarpfiN/yOmo/9s/8A0Wtc1QAUUUUAFFFFABRRRQB7b8N/+RK0/wD7\n" +
            "af8Aoxq6Sub+G/8AyJWn/wDbT/0Y1dJQAUUUUAFFFFABRRRQB4n8Rv8AkdNR/wC2f/ota5qul+I3\n" +
            "/I6aj/2z/wDRa1zVABRRRQAUUUUAFFFFAHtvw3/5ErT/APtp/wCjGrpK5v4b/wDIlaf/ANtP/RjV\n" +
            "0lABRRRQAUUUUAFFFFAHifxG/wCR01H/ALZ/+i1rmq6X4jf8jpqP/bP/ANFrXNUAFFFFABRRRQAU\n" +
            "UUUAe2/Df/kStP8A+2n/AKMaukrm/hv/AMiVp/8A20/9GNXSUAFFFFABRRRQAUUUUAeJ/Eb/AJHT\n" +
            "Uf8Atn/6LWuarpfiN/yOmo/9s/8A0Wtc1QAUUUUAFFFFABRRRQB7b8N/+RK0/wD7af8Aoxq6Sub+\n" +
            "G/8AyJWn/wDbT/0Y1dJQAUVxH/CytG/59tQ/74T/AOLo/wCFlaN/z7ah/wB8J/8AF0AdvRXEf8LK\n" +
            "0b/n21D/AL4T/wCLo/4WVo3/AD7ah/3wn/xdAHb0VxH/AAsrRv8An21D/vhP/i6P+FlaN/z7ah/3\n" +
            "wn/xdAHFfEb/AJHTUf8Atn/6LWuar0DUfDV54wvZdd0yW3itLrGxLhmVxtGw5ABHVT3PGKq/8K11\n" +
            "n/n60/8A7+P/APEUAcTRXbf8K11n/n60/wD7+P8A/EUf8K11n/n60/8A7+P/APEUAcTRXbf8K11n\n" +
            "/n60/wD7+P8A/EUf8K11n/n60/8A7+P/APEUAcTRXbf8K11n/n60/wD7+P8A/EUf8K11n/n60/8A\n" +
            "7+P/APEUAdv8N/8AkStP/wC2n/oxq6SuA03xLZ+D7KPQtTiuJbu1zve3UMh3EuMEkHow7DvVj/hZ\n" +
            "Wjf8+2of98J/8XQB29FcR/wsrRv+fbUP++E/+Lo/4WVo3/PtqH/fCf8AxdAHb0VxH/CytG/59tQ/\n" +
            "74T/AOLo/wCFlaN/z7ah/wB8J/8AF0AdvRXEf8LK0b/n21D/AL4T/wCLo/4WVo3/AD7ah/3wn/xd\n" +
            "AHFfEb/kdNR/7Z/+i1rmq9A1Hw1eeML2XXdMlt4rS6xsS4ZlcbRsOQAR1U9zxiqv/CtdZ/5+tP8A\n" +
            "+/j/APxFAHE0V23/AArXWf8An60//v4//wARR/wrXWf+frT/APv4/wD8RQBxNFdt/wAK11n/AJ+t\n" +
            "P/7+P/8AEUf8K11n/n60/wD7+P8A/EUAcTRXbf8ACtdZ/wCfrT/+/j//ABFH/CtdZ/5+tP8A+/j/\n" +
            "APxFAHb/AA3/AORK0/8A7af+jGrpK4DTfEtn4Pso9C1OK4lu7XO97dQyHcS4wSQejDsO9WP+FlaN\n" +
            "/wA+2of98J/8XQB29FcR/wALK0b/AJ9tQ/74T/4uj/hZWjf8+2of98J/8XQB29FcR/wsrRv+fbUP\n" +
            "++E/+Lo/4WVo3/PtqH/fCf8AxdAHb0VxH/CytG/59tQ/74T/AOLo/wCFlaN/z7ah/wB8J/8AF0Ac\n" +
            "V8Rv+R01H/tn/wCi1rmq9A1Hw1eeML2XXdMlt4rS6xsS4ZlcbRsOQAR1U9zxiqv/AArXWf8An60/\n" +
            "/v4//wARQBxNFdt/wrXWf+frT/8Av4//AMRR/wAK11n/AJ+tP/7+P/8AEUAcTRXbf8K11n/n60//\n" +
            "AL+P/wDEUf8ACtdZ/wCfrT/+/j//ABFAHE0V23/CtdZ/5+tP/wC/j/8AxFH/AArXWf8An60//v4/\n" +
            "/wARQB2/w3/5ErT/APtp/wCjGrpK4DTfEtn4Pso9C1OK4lu7XO97dQyHcS4wSQejDsO9WP8AhZWj\n" +
            "f8+2of8AfCf/ABdAHb0VxH/CytG/59tQ/wC+E/8Ai6P+FlaN/wA+2of98J/8XQB29FcR/wALK0b/\n" +
            "AJ9tQ/74T/4uj/hZWjf8+2of98J/8XQB29FcR/wsrRv+fbUP++E/+Lo/4WVo3/PtqH/fCf8AxdAH\n" +
            "FfEb/kdNR/7Z/wDota5qvQNR8NXnjC9l13TJbeK0usbEuGZXG0bDkAEdVPc8Yqr/AMK11n/n60//\n" +
            "AL+P/wDEUAcTRXbf8K11n/n60/8A7+P/APEUf8K11n/n60//AL+P/wDEUAcTRXbf8K11n/n60/8A\n" +
            "7+P/APEUf8K11n/n60//AL+P/wDEUAcTRXbf8K11n/n60/8A7+P/APEUf8K11n/n60//AL+P/wDE\n" +
            "UAdv8N/+RK0//tp/6MaukrgNN8S2fg+yj0LU4riW7tc73t1DIdxLjBJB6MOw71Y/4WVo3/PtqH/f\n" +
            "Cf8AxdAHb0VxH/CytG/59tQ/74T/AOLo/wCFlaN/z7ah/wB8J/8AF0AdvRXEf8LK0b/n21D/AL4T\n" +
            "/wCLo/4WVo3/AD7ah/3wn/xdAHb0VxH/AAsrRv8An21D/vhP/i6P+FlaN/z7ah/3wn/xdAHFfEb/\n" +
            "AJHTUf8Atn/6LWuar0DUfDV54wvZdd0yW3itLrGxLhmVxtGw5ABHVT3PGKq/8K11n/n60/8A7+P/\n" +
            "APEUAcTRXbf8K11n/n60/wD7+P8A/EUf8K11n/n60/8A7+P/APEUAcTRXbf8K11n/n60/wD7+P8A\n" +
            "/EUf8K11n/n60/8A7+P/APEUAcTRXbf8K11n/n60/wD7+P8A/EUf8K11n/n60/8A7+P/APEUAdv8\n" +
            "N/8AkStP/wC2n/oxq6SuA03xLZ+D7KPQtTiuJbu1zve3UMh3EuMEkHow7DvVj/hZWjf8+2of98J/\n" +
            "8XQB5LRRRQAUUUUAFFFFAHtvw3/5ErT/APtp/wCjGrpK5v4b/wDIlaf/ANtP/RjV0lABRRRQAUUU\n" +
            "UAFFFFAHifxG/wCR01H/ALZ/+i1rmq6X4jf8jpqP/bP/ANFrXNUAFFFFABRRRQAUUUUAe2/Df/kS\n" +
            "tP8A+2n/AKMaukrm/hv/AMiVp/8A20/9GNXSUAFFFFABRRRQAUUUUAeJ/Eb/AJHTUf8Atn/6LWua\n" +
            "rpfiN/yOmo/9s/8A0Wtc1QAUUUUAFFFFABRRRQB7b8N/+RK0/wD7af8Aoxq6Sub+G/8AyJWn/wDb\n" +
            "T/0Y1dJQAUUUUAFFFFABRRRQB4n8Rv8AkdNR/wC2f/ota5qul+I3/I6aj/2z/wDRa1zVABRRRQAU\n" +
            "UUUAFFFFAHtvw3/5ErT/APtp/wCjGrpK5v4b/wDIlaf/ANtP/RjV0lABRRRQAUUUUAFFFFAHifxG\n" +
            "/wCR01H/ALZ/+i1rmq6X4jf8jpqP/bP/ANFrXNUAFFFFABRRRQAUUUUAe2/Df/kStP8A+2n/AKMa\n" +
            "ukrm/hv/AMiVp/8A20/9GNXSUAFFFFABRRRQAUUUUAeJ/Eb/AJHTUf8Atn/6LWuarpfiN/yOmo/9\n" +
            "s/8A0Wtc1QAUUUUAFFFFABRRRQB7b8N/+RK0/wD7af8Aoxq6Sub+G/8AyJWn/wDbT/0Y1dJQAUUU\n" +
            "UAFFFFABRRRQB4n8Rv8AkdNR/wC2f/ota5qul+I3/I6aj/2z/wDRa1zVABRRRQAUUUUAFFFFAHtv\n" +
            "w3/5ErT/APtp/wCjGrpK5v4b/wDIlaf/ANtP/RjV0lABRRRQAUUUUAFFFFAHifxG/wCR01H/ALZ/\n" +
            "+i1rmq6X4jf8jpqP/bP/ANFrXNUAFFFFABRRRQAUUUUAe2/Df/kStP8A+2n/AKMaukrm/hv/AMiV\n" +
            "p/8A20/9GNXSUAFFFFABRRRQAUUUUAeJ/Eb/AJHTUf8Atn/6LWuarpfiN/yOmo/9s/8A0Wtc1QAU\n" +
            "UUUAFFFFABRRRQB7b8N/+RK0/wD7af8Aoxq6Sub+G/8AyJWn/wDbT/0Y1dJQAUUUUAFFFFABRRRQ\n" +
            "B4n8Rv8AkdNR/wC2f/ota5qul+I3/I6aj/2z/wDRa1zVABRRRQAUUUUAFFFFAHtvw3/5ErT/APtp\n" +
            "/wCjGrpK5v4b/wDIlaf/ANtP/RjV0lABRRRQAUUUUAFFFFAHifxG/wCR01H/ALZ/+i1rmq6X4jf8\n" +
            "jpqP/bP/ANFrXNUAFFFFABRRRQAUUUUAe2/Df/kStP8A+2n/AKMaukrm/hv/AMiVp/8A20/9GNXS\n" +
            "UAFFFFABRRRQAUUUUAeJ/Eb/AJHTUf8Atn/6LWuarpfiN/yOmo/9s/8A0Wtc1QAUUUUAFFFFABRR\n" +
            "RQB7b8N/+RK0/wD7af8Aoxq6Sub+G/8AyJWn/wDbT/0Y1dJQAUUUUAFFFFABRRRQB4n8Rv8AkdNR\n" +
            "/wC2f/ota5qul+I3/I6aj/2z/wDRa1zVABRRRQAUUUUAFFFFAHtvw3/5ErT/APtp/wCjGrpK5v4b\n" +
            "/wDIlaf/ANtP/RjV0lABRRRQAUUUUAFFFFAHifxG/wCR01H/ALZ/+i1rmq6X4jf8jpqP/bP/ANFr\n" +
            "XNUAFFFFABRRRQAUUUUAe2/Df/kStP8A+2n/AKMaukrm/hv/AMiVp/8A20/9GNXSUAFFFFABRRRQ\n" +
            "AUUUUAeJ/Eb/AJHTUf8Atn/6LWuarpfiN/yOmo/9s/8A0Wtc1QAUUUUAFFFFABRRRQB7b8N/+RK0\n" +
            "/wD7af8Aoxq6Sub+G/8AyJWn/wDbT/0Y1dJQAUUUUAFFFFABRRRQB4n8Rv8AkdNR/wC2f/ota5qu\n" +
            "l+I3/I6aj/2z/wDRa1zVABRXSf8ACDeI/wDoHf8AkaP/AOKo/wCEG8R/9A7/AMjR/wDxVAHN0V0n\n" +
            "/CDeI/8AoHf+Ro//AIqj/hBvEf8A0Dv/ACNH/wDFUAc3RXSf8IN4j/6B3/kaP/4qj/hBvEf/AEDv\n" +
            "/I0f/wAVQB6T8N/+RK0//tp/6MaukrifDeuad4a0W30nW7n7NqFvu8yLYz7dzFhyoI5VgeD3rS/4\n" +
            "Tnw5/wBBH/yDJ/8AE0AdJRXN/wDCc+HP+gj/AOQZP/iaP+E58Of9BH/yDJ/8TQB0lFc3/wAJz4c/\n" +
            "6CP/AJBk/wDiaP8AhOfDn/QR/wDIMn/xNAGp9pl/v/oKPtMv9/8AQVFijFfG/Wq/87+9nwP1zEf8\n" +
            "/JfezJ1Hw7pWpXsl3e2vm3EmNzeYwzgYHAOOgFVv+EO0H/nw/wDIr/8AxVb+KMUfWq/87+9h9cxH\n" +
            "/PyX3swP+EO0H/nw/wDIr/8AxVH/AAh2g/8APh/5Ff8A+KrfxRij61X/AJ397D65iP8An5L72YH/\n" +
            "AAh2g/8APh/5Ff8A+Ko/4Q7Qf+fD/wAiv/8AFVv4oxR9ar/zv72H1zEf8/JfezA/4Q7Qf+fD/wAi\n" +
            "v/8AFUf8IdoP/Ph/5Ff/AOKrfxRij61X/nf3sPrmI/5+S+9kemwx6bZR2livlW8edq5zjJJPJ56k\n" +
            "1Z+0y/3/ANBUWKMUfWq/87+9h9cxH/PyX3sl+0y/3/0FH2mX+/8AoKixRij61X/nf3sPrmI/5+S+\n" +
            "9kv2mX+/+go+0y/3/wBBUWKMUfWq/wDO/vYfXMR/z8l97JftMv8Af/QUfaZf7/6CosUYo+tV/wCd\n" +
            "/ew+uYj/AJ+S+9mTqPh3StSvZLu9tfNuJMbm8xhnAwOAcdAKrf8ACHaD/wA+H/kV/wD4qt/FGKPr\n" +
            "Vf8Anf3sPrmI/wCfkvvZ4HRXSf8ACDeI/wDoHf8AkaP/AOKo/wCEG8R/9A7/AMjR/wDxVfZH3xzd\n" +
            "FdJ/wg3iP/oHf+Ro/wD4qj/hBvEf/QO/8jR//FUAc3RXSf8ACDeI/wDoHf8AkaP/AOKo/wCEG8R/\n" +
            "9A7/AMjR/wDxVAHpPw3/AORK0/8A7af+jGrpK4nw3rmneGtFt9J1u5+zahb7vMi2M+3cxYcqCOVY\n" +
            "Hg960v8AhOfDn/QR/wDIMn/xNAHSUVzf/Cc+HP8AoI/+QZP/AImj/hOfDn/QR/8AIMn/AMTQB0lF\n" +
            "c3/wnPhz/oI/+QZP/iaP+E58Of8AQR/8gyf/ABNAHSUVzf8AwnPhz/oI/wDkGT/4mj/hOfDn/QR/\n" +
            "8gyf/E0Aeb/Eb/kdNR/7Z/8Aota5qu28R6HqPiXWrnVtEtvtOn3G3y5d6pu2qFPDEHqp6is3/hBv\n" +
            "Ef8A0Dv/ACNH/wDFUAc3RXSf8IN4j/6B3/kaP/4qj/hBvEf/AEDv/I0f/wAVQBzdFdJ/wg3iP/oH\n" +
            "f+Ro/wD4qj/hBvEf/QO/8jR//FUAc3RXSf8ACDeI/wDoHf8AkaP/AOKo/wCEG8R/9A7/AMjR/wDx\n" +
            "VAHpPw3/AORK0/8A7af+jGrpK4nw3rmneGtFt9J1u5+zahb7vMi2M+3cxYcqCOVYHg960v8AhOfD\n" +
            "n/QR/wDIMn/xNAHSUVzf/Cc+HP8AoI/+QZP/AImj/hOfDn/QR/8AIMn/AMTQB0lFc3/wnPhz/oI/\n" +
            "+QZP/iaP+E58Of8AQR/8gyf/ABNAHSUVzf8AwnPhz/oI/wDkGT/4mj/hOfDn/QR/8gyf/E0Aeb/E\n" +
            "b/kdNR/7Z/8Aota5qu28R6HqPiXWrnVtEtvtOn3G3y5d6pu2qFPDEHqp6is3/hBvEf8A0Dv/ACNH\n" +
            "/wDFUAc3RXSf8IN4j/6B3/kaP/4qj/hBvEf/AEDv/I0f/wAVQBzdFdJ/wg3iP/oHf+Ro/wD4qj/h\n" +
            "BvEf/QO/8jR//FUAc3RXSf8ACDeI/wDoHf8AkaP/AOKo/wCEG8R/9A7/AMjR/wDxVAHpPw3/AORK\n" +
            "0/8A7af+jGrpK4nw3rmneGtFt9J1u5+zahb7vMi2M+3cxYcqCOVYHg960v8AhOfDn/QR/wDIMn/x\n" +
            "NAHSUVzf/Cc+HP8AoI/+QZP/AImj/hOfDn/QR/8AIMn/AMTQB0lFc3/wnPhz/oI/+QZP/iaP+E58\n" +
            "Of8AQR/8gyf/ABNAHSUVzf8AwnPhz/oI/wDkGT/4mj/hOfDn/QR/8gyf/E0Aeb/Eb/kdNR/7Z/8A\n" +
            "ota5qu28R6HqPiXWrnVtEtvtOn3G3y5d6pu2qFPDEHqp6is3/hBvEf8A0Dv/ACNH/wDFUAe20UUU\n" +
            "AFFFFABRRRQB4n8Rv+R01H/tn/6LWuarpfiN/wAjpqP/AGz/APRa1zVABRRRQAUUUUAe+UUUV8Mf\n" +
            "nAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQBq0UUV9yfo4UUUUAFFFFAHifxG/\n" +
            "5HTUf+2f/ota5qul+I3/ACOmo/8AbP8A9FrXNUAFFFFABRRRQAUUUUAe2/Df/kStP/7af+jGrpK5\n" +
            "v4b/APIlaf8A9tP/AEY1dJQAUUUUAFFFFABRRRQB4n8Rv+R01H/tn/6LWuarpfiN/wAjpqP/AGz/\n" +
            "APRa1zVABRRRQAUUUUAFFFFAHtvw3/5ErT/+2n/oxq6Sub+G/wDyJWn/APbT/wBGNXSUAFFFFABR\n" +
            "RRQAUUUUAeJ/Eb/kdNR/7Z/+i1rmq6X4jf8AI6aj/wBs/wD0Wtc1QAUUUUAFFFFABRRRQB7b8N/+\n" +
            "RK0//tp/6Maukrm/hv8A8iVp/wD20/8ARjV0lABRRRQAUUUUAFFFFAHifxG/5HTUf+2f/ota5qul\n" +
            "+I3/ACOmo/8AbP8A9FrXNUAFFFFABRRRQB75RRRXwx+cBRRRQAUUUUAFFFFABRRRQAUUUUAFFFFA\n" +
            "BRRRQAUUUUAFFFFAGrRRRX3J+jhRRRQAUUUUAeJ/Eb/kdNR/7Z/+i1rmq6X4jf8AI6aj/wBs/wD0\n" +
            "Wtc1QAUUUUAFFFFABRRRQB7b8N/+RK0//tp/6Maukrm/hv8A8iVp/wD20/8ARjV0lABRRRQAUUUU\n" +
            "AFFFFAHifxG/5HTUf+2f/ota5qul+I3/ACOmo/8AbP8A9FrXNUAFFFFABRRRQAUUUUAe2/Df/kSt\n" +
            "P/7af+jGrpK5v4b/APIlaf8A9tP/AEY1dJQAUUUUAFFFFABRRRQB4n8Rv+R01H/tn/6LWuarpfiN\n" +
            "/wAjpqP/AGz/APRa1zVABRRRQAUUUUAFFFFAHtvw3/5ErT/+2n/oxq6Sub+G/wDyJWn/APbT/wBG\n" +
            "NXSUAFFFFABRRRQAUUUUAeJ/Eb/kdNR/7Z/+i1rmq6X4jf8AI6aj/wBs/wD0Wtc1QAUUUUAFFFFA\n" +
            "HvlFFFfDH5wFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAatFFFfcn6OFFFFABR\n" +
            "RRQB4n8Rv+R01H/tn/6LWuarpfiN/wAjpqP/AGz/APRa1zVABRRRQAUUUUAFFFFAHtvw3/5ErT/+\n" +
            "2n/oxq6Sub+G/wDyJWn/APbT/wBGNXSUAFFFFABRRRQAUUUUAeJ/Eb/kdNR/7Z/+i1rmq6X4jf8A\n" +
            "I6aj/wBs/wD0Wtc1QAUUUUAFFFFABRRRQB7b8N/+RK0//tp/6Maukrm/hv8A8iVp/wD20/8ARjV0\n" +
            "lABRRRQAUUUUAFFFFAHifxG/5HTUf+2f/ota5qul+I3/ACOmo/8AbP8A9FrXNUAFFFFABRRRQAUU\n" +
            "UUAe2/Df/kStP/7af+jGrpK5v4b/APIlaf8A9tP/AEY1dJQAUVm/29o3/QX0/wD8CE/xo/t7Rv8A\n" +
            "oL6f/wCBCf40AaVFZv8Ab2jf9BfT/wDwIT/Gj+3tG/6C+n/+BCf40AaVFZv9vaN/0F9P/wDAhP8A\n" +
            "Gj+3tG/6C+n/APgQn+NAHkvxG/5HTUf+2f8A6LWuarrfGtheap4nvbzTLS4vLSTZsmt42kRsIAcM\n" +
            "AQcEEfhWJ/YGs/8AQI1D/wAB3/woAzaK0v7A1n/oEah/4Dv/AIUf2BrP/QI1D/wHf/CgDNorS/sD\n" +
            "Wf8AoEah/wCA7/4Uf2BrP/QI1D/wHf8AwoA9qooor4Y/OAooooAKKKKACiiigAooooAKKKKACiii\n" +
            "gAooooAKKKKACiiigDVorN/t7Rv+gvp//gQn+NH9vaN/0F9P/wDAhP8AGvuT9HNKis3+3tG/6C+n\n" +
            "/wDgQn+NH9vaN/0F9P8A/AhP8aANKis3+3tG/wCgvp//AIEJ/jR/b2jf9BfT/wDwIT/GgDyX4jf8\n" +
            "jpqP/bP/ANFrXNV1vjWwvNU8T3t5plpcXlpJs2TW8bSI2EAOGAIOCCPwrE/sDWf+gRqH/gO/+FAG\n" +
            "bRWl/YGs/wDQI1D/AMB3/wAKP7A1n/oEah/4Dv8A4UAZtFaX9gaz/wBAjUP/AAHf/Cj+wNZ/6BGo\n" +
            "f+A7/wCFAGbRWl/YGs/9AjUP/Ad/8KP7A1n/AKBGof8AgO/+FAHrfw3/AORK0/8A7af+jGrpK5Lw\n" +
            "Tf2el+F7Oz1O7t7O7j374biQRuuXYjKk5GQQfxFbf9vaN/0F9P8A/AhP8aANKis3+3tG/wCgvp//\n" +
            "AIEJ/jR/b2jf9BfT/wDwIT/GgDSorN/t7Rv+gvp//gQn+NH9vaN/0F9P/wDAhP8AGgDSorN/t7Rv\n" +
            "+gvp/wD4EJ/jR/b2jf8AQX0//wACE/xoA8l+I3/I6aj/ANs//Ra1zVdb41sLzVPE97eaZaXF5aSb\n" +
            "Nk1vG0iNhADhgCDggj8KxP7A1n/oEah/4Dv/AIUAZtFaX9gaz/0CNQ/8B3/wo/sDWf8AoEah/wCA\n" +
            "7/4UAZtFaX9gaz/0CNQ/8B3/AMKP7A1n/oEah/4Dv/hQBm0Vpf2BrP8A0CNQ/wDAd/8ACj+wNZ/6\n" +
            "BGof+A7/AOFAHrfw3/5ErT/+2n/oxq6SuS8E39npfhezs9Tu7ezu49++G4kEbrl2IypORkEH8RW3\n" +
            "/b2jf9BfT/8AwIT/ABoA0qKzf7e0b/oL6f8A+BCf40f29o3/AEF9P/8AAhP8aANKis3+3tG/6C+n\n" +
            "/wDgQn+NH9vaN/0F9P8A/AhP8aANKis3+3tG/wCgvp//AIEJ/jR/b2jf9BfT/wDwIT/GgDyX4jf8\n" +
            "jpqP/bP/ANFrXNV1vjWwvNU8T3t5plpcXlpJs2TW8bSI2EAOGAIOCCPwrE/sDWf+gRqH/gO/+FAG\n" +
            "bRWl/YGs/wDQI1D/AMB3/wAKP7A1n/oEah/4Dv8A4UAZtFaX9gaz/wBAjUP/AAHf/Cj+wNZ/6BGo\n" +
            "f+A7/wCFAGbRWl/YGs/9AjUP/Ad/8KP7A1n/AKBGof8AgO/+FAHrfw3/AORK0/8A7af+jGrpK5Lw\n" +
            "Tf2el+F7Oz1O7t7O7j374biQRuuXYjKk5GQQfxFbf9vaN/0F9P8A/AhP8aAPAKKKKACiiigAoooo\n" +
            "A9t+G/8AyJWn/wDbT/0Y1dJXN/Df/kStP/7af+jGrpKACiiigAooooAyqKKK+GPzgKKKKACiiigA\n" +
            "ooooAKKKKACiiigAooooAKKKKACiiigAooooA8Dooor7k/RwooooAKKKKAPbfhv/AMiVp/8A20/9\n" +
            "GNXSVzfw3/5ErT/+2n/oxq6SgAooooAKKKKACiiigDxP4jf8jpqP/bP/ANFrXNV0vxG/5HTUf+2f\n" +
            "/ota5qgAooooAKKKKACiiigD234b/wDIlaf/ANtP/RjV0lc38N/+RK0//tp/6MaukoAKKKKACiii\n" +
            "gAooooA8T+I3/I6aj/2z/wDRa1zVdL8Rv+R01H/tn/6LWuaoAKKKKACiiigAooooA9t+G/8AyJWn\n" +
            "/wDbT/0Y1dJXN/Df/kStP/7af+jGrpKACiiigAooooAKKKKAPE/iN/yOmo/9s/8A0Wtc1XS/Eb/k\n" +
            "dNR/7Z/+i1rmqACiiigAooooAKKKKAPbfhv/AMiVp/8A20/9GNXSVzfw3/5ErT/+2n/oxq6SgAoo\n" +
            "ooAKKKKAMqiiivhj84CiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAPA6KKK+5P0\n" +
            "cKKKKACiiigD234b/wDIlaf/ANtP/RjV0lc38N/+RK0//tp/6MaukoAKKKKACiiigAooooA8T+I3\n" +
            "/I6aj/2z/wDRa1zVdL8Rv+R01H/tn/6LWuaoAKKKKACiiigAooooA9t+G/8AyJWn/wDbT/0Y1dJX\n" +
            "N/Df/kStP/7af+jGrpKACiiigAooooAKKKKAPE/iN/yOmo/9s/8A0Wtc1XS/Eb/kdNR/7Z/+i1rm\n" +
            "qACiiigAooooAKKKKAPbfhv/AMiVp/8A20/9GNXSVzfw3/5ErT/+2n/oxq6SgAooooAKKKKACiii\n" +
            "gDxP4jf8jpqP/bP/ANFrXNV0vxG/5HTUf+2f/ota5qgAooooAKKKKACiiigD234b/wDIlaf/ANtP\n" +
            "/RjV0lc38N/+RK0//tp/6MaukoAKKKKACiiigDKooor4Y/OAooooAKKKKACiiigAooooAKKKKACi\n" +
            "iigAooooAKKKKACiiigDwOiiivuT9HCiiigAooooA9t+G/8AyJWn/wDbT/0Y1dJXN/Df/kStP/7a\n" +
            "f+jGrpKACiiigAooooAKKKKAPE/iN/yOmo/9s/8A0Wtc1XS/Eb/kdNR/7Z/+i1rmqACiiigAoooo\n" +
            "AKKKKAPbfhv/AMiVp/8A20/9GNXSVzfw3/5ErT/+2n/oxq6SgAooooAKKKKACiiigDxP4jf8jpqP\n" +
            "/bP/ANFrXNV0vxG/5HTUf+2f/ota5qgAooooAKKKKACiiigD234b/wDIlaf/ANtP/RjV0lc38N/+\n" +
            "RK0//tp/6MaukoAKKKKACiiigAooooA8T+I3/I6aj/2z/wDRa1zVdL8Rv+R01H/tn/6LWuaoAKKK\n" +
            "KACiiigAooooA9t+G/8AyJWn/wDbT/0Y1dJXN/Df/kStP/7af+jGrpKACiiigAooooAyqKKK+GPz\n" +
            "gKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA8Dooor7k/RwooooAKKKKAPbfhv/\n" +
            "AMiVp/8A20/9GNXSVzfw3/5ErT/+2n/oxq6SgAooooAKKKKACiiigDxP4jf8jpqP/bP/ANFrXNV0\n" +
            "vxG/5HTUf+2f/ota5qgAooooAKKKKACiiigD234b/wDIlaf/ANtP/RjV0lc38N/+RK0//tp/6Mau\n" +
            "koAKKKKACiiigAooooA8T+I3/I6aj/2z/wDRa1zVdL8Rv+R01H/tn/6LWuaoAKKKKACiiigAoooo\n" +
            "A9t+G/8AyJWn/wDbT/0Y1dJXN/Df/kStP/7af+jGrpKACiiigAooooAKKKKAPE/iN/yOmo/9s/8A\n" +
            "0Wtc1XS/Eb/kdNR/7Z/+i1rmqAPpGiiigAooooAKKKKAPE/iN/yOmo/9s/8A0Wtc1XS/Eb/kdNR/\n" +
            "7Z/+i1rmqACiiigAooooA98ooor4Y/OAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACi\n" +
            "iigDVooor7k/RwooooAKKKKAPE/iN/yOmo/9s/8A0Wtc1XS/Eb/kdNR/7Z/+i1rmqACiiigAoooo\n" +
            "AKKKKAPbfhv/AMiVp/8A20/9GNXSVzfw3/5ErT/+2n/oxq6SgAooooAKKKKACiiigDxP4jf8jpqP\n" +
            "/bP/ANFrXNV0vxG/5HTUf+2f/ota5qgAooooAKKKKACiiigD234b/wDIlaf/ANtP/RjV0lc38N/+\n" +
            "RK0//tp/6MaukoAKKKKACiiigAooooA8T+I3/I6aj/2z/wDRa1zVdL8Rv+R01H/tn/6LWuaoAKKK\n" +
            "KACiiigAooooA9t+G/8AyJWn/wDbT/0Y1dJXN/Df/kStP/7af+jGrpKACiiigAooooAKKKKAPE/i\n" +
            "N/yOmo/9s/8A0Wtc1XS/Eb/kdNR/7Z/+i1rmqACiiigAooooA3v+Ex17/n//APISf/E0f8Jjr3/P\n" +
            "/wD+Qk/+JrAorD6rR/kX3I5vqeH/AOfcfuR7j4JmfUvDFnd3rebcSb9zYxnDsBwOOgFbf2eL+7+p\n" +
            "rA+G/wDyJWn/APbT/wBGNXSUfVaP8i+5B9Tw/wDz7j9yIvs8X939TR9ni/u/qaloo+q0f5F9yD6n\n" +
            "h/8An3H7kRfZ4v7v6mj7PF/d/U1LRR9Vo/yL7kH1PD/8+4/ciL7PF/d/U0fZ4v7v6mpaKPqtH+Rf\n" +
            "cg+p4f8A59x+5HlPjXxHqum+J720srvyrePZtXy1OMoCeSM9TWH/AMJjr3/P/wD+Qk/+JqX4jf8A\n" +
            "I6aj/wBs/wD0Wtc3R9Vo/wAi+5B9Tw//AD7j9yN//hMde/5//wDyEn/xNH/CY69/z/8A/kJP/iaw\n" +
            "KKPqtH+Rfcg+p4f/AJ9x+5G//wAJjr3/AD//APkJP/iaP+Ex17/n/wD/ACEn/wATWBRR9Vo/yL7k\n" +
            "H1PD/wDPuP3I3/8AhMde/wCf/wD8hJ/8TR/wmOvf8/8A/wCQk/8AiawKKPqtH+Rfcg+p4f8A59x+\n" +
            "5HuPgmZ9S8MWd3et5txJv3NjGcOwHA46AVt/Z4v7v6msD4b/APIlaf8A9tP/AEY1dJR9Vo/yL7kH\n" +
            "1PD/APPuP3IWiiitzpCiiigAooooA8T+I3/I6aj/ANs//Ra1zVdL8Rv+R01H/tn/AOi1rmqACiii\n" +
            "gAooooAKKKKAPbfhv/yJWn/9tP8A0Y1dJXN/Df8A5ErT/wDtp/6MaukoAKKKKACiiigAooooA8T+\n" +
            "I3/I6aj/ANs//Ra1zVdL8Rv+R01H/tn/AOi1rmqACiiigAooooAKKKKAPbfhv/yJWn/9tP8A0Y1d\n" +
            "JXN/Df8A5ErT/wDtp/6MaukoAKKKKACiiigAooooA8T+I3/I6aj/ANs//Ra1zVdL8Rv+R01H/tn/\n" +
            "AOi1rmqACiiigAooooAKKKKAPbfhv/yJWn/9tP8A0Y1dJXN/Df8A5ErT/wDtp/6MaukoAKKKKACi\n" +
            "iigAooooA8T+I3/I6aj/ANs//Ra1zVdL8Rv+R01H/tn/AOi1rmqACiiigAooooAKKKKAPbfhv/yJ\n" +
            "Wn/9tP8A0Y1dJXN/Df8A5ErT/wDtp/6MaukoAKKKKACiiigAooooA8T+I3/I6aj/ANs//Ra1zVdL\n" +
            "8Rv+R01H/tn/AOi1rmqACiiigAooooAKKKKAPbfhv/yJWn/9tP8A0Y1dJXN/Df8A5ErT/wDtp/6M\n" +
            "aukoAKKKKACiiigAooooA8T+I3/I6aj/ANs//Ra1zVdL8Rv+R01H/tn/AOi1rmqACiiigAooooAK\n" +
            "KKKAPbfhv/yJWn/9tP8A0Y1dJXN/Df8A5ErT/wDtp/6MaukoAKKKKACiiigAooooA8T+I3/I6aj/\n" +
            "ANs//Ra1zVdL8Rv+R01H/tn/AOi1rmqACiiigAooooAKKKKAPbfhv/yJWn/9tP8A0Y1dJXN/Df8A\n" +
            "5ErT/wDtp/6MaukoAKKKKACiiigAooooA8T+I3/I6aj/ANs//Ra1zVdL8Rv+R01H/tn/AOi1rmqA\n" +
            "CiiigAooooAKKKKAPbfhv/yJWn/9tP8A0Y1dJXN/Df8A5ErT/wDtp/6MaukoAKKKKACiiigAoooo\n" +
            "A8T+I3/I6aj/ANs//Ra1zVdL8Rv+R01H/tn/AOi1rmqACiiigAooooAKKKKAPbfhv/yJWn/9tP8A\n" +
            "0Y1dJXN/Df8A5ErT/wDtp/6MaukoAKKKKACiiigAooooA8T+I3/I6aj/ANs//Ra1zVdL8Rv+R01H\n" +
            "/tn/AOi1rmqACiiigAooooAKKKKAPbfhv/yJWn/9tP8A0Y1dJXN/Df8A5ErT/wDtp/6MaukoAKKK\n" +
            "KACiiigAooooA8T+I3/I6aj/ANs//Ra1zVdL8Rv+R01H/tn/AOi1rmqACiiigAooooAKKKKAPbfh\n" +
            "v/yJWn/9tP8A0Y1dJXN/Df8A5ErT/wDtp/6MaukoAKKKKACiiigAooooA8T+I3/I6aj/ANs//Ra1\n" +
            "zVdL8Rv+R01H/tn/AOi1rmqACiiigAooooAKKKKAPbfhv/yJWn/9tP8A0Y1dJXN/Df8A5ErT/wDt\n" +
            "p/6MaukoAKKKKACiiigAooooA8T+I3/I6aj/ANs//Ra1zVdL8Rv+R01H/tn/AOi1rmqACiiigAoo\n" +
            "ooAKKKKAPbfhv/yJWn/9tP8A0Y1dJXN/Df8A5ErT/wDtp/6MaukoA8A/t/Wf+gvqH/gQ/wDjR/b+\n" +
            "s/8AQX1D/wACH/xrNooA0v7f1n/oL6h/4EP/AI0f2/rP/QX1D/wIf/Gs2igDS/t/Wf8AoL6h/wCB\n" +
            "D/40f2/rP/QX1D/wIf8AxrNooA9k8E2FnqnhezvNTtLe8u5N++a4jEjvh2AyxyTgAAfStv8AsHRv\n" +
            "+gRp/wD4Dp/hWb8N/wDkStP/AO2n/oxq6SgDN/sHRv8AoEaf/wCA6f4Uf2Do3/QI0/8A8B0/wrSo\n" +
            "oAzf7B0b/oEaf/4Dp/hR/YOjf9AjT/8AwHT/AArSooAzf7B0b/oEaf8A+A6f4Uf2Do3/AECNP/8A\n" +
            "AdP8K0qKAPG/Gt/eaX4nvbPTLu4s7SPZsht5GjRcoCcKDgZJJ/E1if2/rP8A0F9Q/wDAh/8AGtP4\n" +
            "jf8AI6aj/wBs/wD0Wtc1QBpf2/rP/QX1D/wIf/Gj+39Z/wCgvqH/AIEP/jWbRQBpf2/rP/QX1D/w\n" +
            "If8Axo/t/Wf+gvqH/gQ/+NZtFAGl/b+s/wDQX1D/AMCH/wAaP7f1n/oL6h/4EP8A41m0UAeyeCbC\n" +
            "z1TwvZ3mp2lveXcm/fNcRiR3w7AZY5JwAAPpW3/YOjf9AjT/APwHT/Cs34b/APIlaf8A9tP/AEY1\n" +
            "dJQBm/2Do3/QI0//AMB0/wAKP7B0b/oEaf8A+A6f4VpUUAZv9g6N/wBAjT//AAHT/Cj+wdG/6BGn\n" +
            "/wDgOn+FaVFAGb/YOjf9AjT/APwHT/Cj+wdG/wCgRp//AIDp/hWlRQB4341v7zS/E97Z6Zd3FnaR\n" +
            "7NkNvI0aLlAThQcDJJP4msT+39Z/6C+of+BD/wCNafxG/wCR01H/ALZ/+i1rmqANL+39Z/6C+of+\n" +
            "BD/40f2/rP8A0F9Q/wDAh/8AGs2igDS/t/Wf+gvqH/gQ/wDjR/b+s/8AQX1D/wACH/xrNooA0v7f\n" +
            "1n/oL6h/4EP/AI0f2/rP/QX1D/wIf/Gs2igD2TwTYWeqeF7O81O0t7y7k375riMSO+HYDLHJOAAB\n" +
            "9K2/7B0b/oEaf/4Dp/hWb8N/+RK0/wD7af8Aoxq6SgDN/sHRv+gRp/8A4Dp/hR/YOjf9AjT/APwH\n" +
            "T/CtKigDN/sHRv8AoEaf/wCA6f4Uf2Do3/QI0/8A8B0/wrSooAzf7B0b/oEaf/4Dp/hR/YOjf9Aj\n" +
            "T/8AwHT/AArSooA8b8a395pfie9s9Mu7iztI9myG3kaNFygJwoOBkkn8TWJ/b+s/9BfUP/Ah/wDG\n" +
            "tP4jf8jpqP8A2z/9FrXNUAaX9v6z/wBBfUP/AAIf/Gj+39Z/6C+of+BD/wCNZtFAGl/b+s/9BfUP\n" +
            "/Ah/8aP7f1n/AKC+of8AgQ/+NZtFAGl/b+s/9BfUP/Ah/wDGj+39Z/6C+of+BD/41m0UAeyeCbCz\n" +
            "1TwvZ3mp2lveXcm/fNcRiR3w7AZY5JwAAPpW3/YOjf8AQI0//wAB0/wrN+G//Ilaf/20/wDRjV0l\n" +
            "AGb/AGDo3/QI0/8A8B0/wo/sHRv+gRp//gOn+FaVFAGb/YOjf9AjT/8AwHT/AAo/sHRv+gRp/wD4\n" +
            "Dp/hWlRQBm/2Do3/AECNP/8AAdP8KP7B0b/oEaf/AOA6f4VpUUAeN+Nb+80vxPe2emXdxZ2kezZD\n" +
            "byNGi5QE4UHAyST+JrE/t/Wf+gvqH/gQ/wDjWn8Rv+R01H/tn/6LWuaoA0v7f1n/AKC+of8AgQ/+\n" +
            "NH9v6z/0F9Q/8CH/AMazaKANL+39Z/6C+of+BD/40f2/rP8A0F9Q/wDAh/8AGs2igDS/t/Wf+gvq\n" +
            "H/gQ/wDjR/b+s/8AQX1D/wACH/xrNooA9k8E2FnqnhezvNTtLe8u5N++a4jEjvh2AyxyTgAAfStv\n" +
            "+wdG/wCgRp//AIDp/hWb8N/+RK0//tp/6MaukoAzf7B0b/oEaf8A+A6f4Uf2Do3/AECNP/8AAdP8\n" +
            "K0qKAM3+wdG/6BGn/wDgOn+FH9g6N/0CNP8A/AdP8K0qKAM3+wdG/wCgRp//AIDp/hR/YOjf9AjT\n" +
            "/wDwHT/CtKigDxvxrf3ml+J72z0y7uLO0j2bIbeRo0XKAnCg4GSSfxNYn9v6z/0F9Q/8CH/xrT+I\n" +
            "3/I6aj/2z/8ARa1zVABRRRQAUUUUAFFFFAHtvw3/AORK0/8A7af+jGrpK5v4b/8AIlaf/wBtP/Rj\n" +
            "V0lABRRRQAUUUUAFFFFAHifxG/5HTUf+2f8A6LWuarpfiN/yOmo/9s//AEWtc1QAUUUUAFFFFABR\n" +
            "RRQB7b8N/wDkStP/AO2n/oxq6Sub+G//ACJWn/8AbT/0Y1dJQAUUUUAFFFFABRRRQB4n8Rv+R01H\n" +
            "/tn/AOi1rmq6X4jf8jpqP/bP/wBFrXNUAFFFFABRRRQAUUUUAe2/Df8A5ErT/wDtp/6Maukrm/hv\n" +
            "/wAiVp//AG0/9GNXSUAFFFFABRRRQAUUUUAeJ/Eb/kdNR/7Z/wDota5qul+I3/I6aj/2z/8ARa1z\n" +
            "VABRRRQAUUUUAFFFFAHtvw3/AORK0/8A7af+jGrpK5v4b/8AIlaf/wBtP/RjV0lABRRRQAUUUUAF\n" +
            "FFFAHifxG/5HTUf+2f8A6LWuarpfiN/yOmo/9s//AEWtc1QAUUUUAFFFFABRRRQB7b8N/wDkStP/\n" +
            "AO2n/oxq6Sub+G//ACJWn/8AbT/0Y1dJQAUUUUAFFFFABRRRQB4n8Rv+R01H/tn/AOi1rmq6X4jf\n" +
            "8jpqP/bP/wBFrXNUAFFFFABRRRQAUUUUAe2/Df8A5ErT/wDtp/6Maukrm/hv/wAiVp//AG0/9GNX\n" +
            "SUAFFFFABRRRQAUUUUAeJ/Eb/kdNR/7Z/wDota5qul+I3/I6aj/2z/8ARa1zVABRRRQAUUUUAFFF\n" +
            "FAHtvw3/AORK0/8A7af+jGrpK5v4b/8AIlaf/wBtP/RjV0lABRRRQAUUUUAFFFFAHifxG/5HTUf+\n" +
            "2f8A6LWuarpfiN/yOmo/9s//AEWtc1QAUUUUAFFFFABRRRQB7b8N/wDkStP/AO2n/oxq6Sub+G//\n" +
            "ACJWn/8AbT/0Y1dJQAUUUUAFFFFABRRRQB4n8Rv+R01H/tn/AOi1rmq6X4jf8jpqP/bP/wBFrXNU\n" +
            "AFFFFABRRRQAUUUUAe2/Df8A5ErT/wDtp/6Maukrm/hv/wAiVp//AG0/9GNXSUAFFFFABRRRQAUU\n" +
            "UUAeJ/Eb/kdNR/7Z/wDota5qul+I3/I6aj/2z/8ARa1zVABRRRQAUUUUAFFFFAHtvw3/AORK0/8A\n" +
            "7af+jGrpK5v4b/8AIlaf/wBtP/RjV0lABRRRQAUUUUAFFFFAHifxG/5HTUf+2f8A6LWuarpfiN/y\n" +
            "Omo/9s//AEWtc1QAUUUUAFFFFABRRRQB7b8N/wDkStP/AO2n/oxq6Sub+G//ACJWn/8AbT/0Y1dJ\n" +
            "QAUUUUAFFFFABRRRQB4n8Rv+R01H/tn/AOi1rmq6X4jf8jpqP/bP/wBFrXNUAFFFFABRRRQAUUUU\n" +
            "Ae2/Df8A5ErT/wDtp/6Maukrm/hv/wAiVp//AG0/9GNXSUAFFFFABRRRQAUUUUAeJ/Eb/kdNR/7Z\n" +
            "/wDota5qul+I3/I6aj/2z/8ARa1zVABRRRQAUUUUAFFFFAHtvw3/AORK0/8A7af+jGrpK5v4b/8A\n" +
            "Ilaf/wBtP/RjV0lABRRRQAUUUUAFFFFAHifxG/5HTUf+2f8A6LWuarpfiN/yOmo/9s//AEWtc1QA\n" +
            "UUUUAFFFFABRRRQB7b8N/wDkStP/AO2n/oxq6Sub+G//ACJWn/8AbT/0Y1dJQAUUUUAFFFFABRRR\n" +
            "QB4n8Rv+R01H/tn/AOi1rmq6X4jf8jpqP/bP/wBFrXNUAFFFFABRRRQAUUUUAe2/Df8A5ErT/wDt\n" +
            "p/6Maukrm/hv/wAiVp//AG0/9GNXSUAFFFFABRRRQAUUUUAeJ/Eb/kdNR/7Z/wDota5qul+I3/I6\n" +
            "aj/2z/8ARa1zVAHtv/CDeHP+gd/5Gk/+Ko/4Qbw5/wBA7/yNJ/8AFV0lFAHN/wDCDeHP+gd/5Gk/\n" +
            "+Ko/4Qbw5/0Dv/I0n/xVdJRQBzf/AAg3hz/oHf8AkaT/AOKo/wCEG8Of9A7/AMjSf/FV0lFAHkni\n" +
            "PXNR8Na1c6Tolz9m0+32+XFsV9u5Qx5YE8lieT3rN/4TnxH/ANBH/wAgx/8AxNL8Rv8AkdNR/wC2\n" +
            "f/ota5qgDpP+E58R/wDQR/8AIMf/AMTR/wAJz4j/AOgj/wCQY/8A4mubooA6T/hOfEf/AEEf/IMf\n" +
            "/wATR/wnPiP/AKCP/kGP/wCJrm6KAOk/4TnxH/0Ef/IMf/xNH/Cc+I/+gj/5Bj/+Jrm6KAPW/Deh\n" +
            "6d4k0W31bW7b7TqFxu8yXeybtrFRwpA4VQOBWl/wg3hz/oHf+RpP/iqPhv8A8iVp/wD20/8ARjV0\n" +
            "lAHN/wDCDeHP+gd/5Gk/+Ko/4Qbw5/0Dv/I0n/xVdJRQBzf/AAg3hz/oHf8AkaT/AOKo/wCEG8Of\n" +
            "9A7/AMjSf/FV0lFAHN/8IN4c/wCgd/5Gk/8AiqP+EG8Of9A7/wAjSf8AxVdJRQB5J4j1zUfDWtXO\n" +
            "k6Jc/ZtPt9vlxbFfbuUMeWBPJYnk96zf+E58R/8AQR/8gx//ABNL8Rv+R01H/tn/AOi1rmqAOk/4\n" +
            "TnxH/wBBH/yDH/8AE0f8Jz4j/wCgj/5Bj/8Aia5uigDpP+E58R/9BH/yDH/8TR/wnPiP/oI/+QY/\n" +
            "/ia5uigDpP8AhOfEf/QR/wDIMf8A8TR/wnPiP/oI/wDkGP8A+Jrm6KAPW/Deh6d4k0W31bW7b7Tq\n" +
            "Fxu8yXeybtrFRwpA4VQOBWl/wg3hz/oHf+RpP/iqPhv/AMiVp/8A20/9GNXSUAc3/wAIN4c/6B3/\n" +
            "AJGk/wDiqP8AhBvDn/QO/wDI0n/xVdJRQBzf/CDeHP8AoHf+RpP/AIqj/hBvDn/QO/8AI0n/AMVX\n" +
            "SUUAc3/wg3hz/oHf+RpP/iqP+EG8Of8AQO/8jSf/ABVdJRQB5J4j1zUfDWtXOk6Jc/ZtPt9vlxbF\n" +
            "fbuUMeWBPJYnk96zf+E58R/9BH/yDH/8TS/Eb/kdNR/7Z/8Aota5qgDpP+E58R/9BH/yDH/8TR/w\n" +
            "nPiP/oI/+QY//ia5uigDpP8AhOfEf/QR/wDIMf8A8TR/wnPiP/oI/wDkGP8A+Jrm6KAOk/4TnxH/\n" +
            "ANBH/wAgx/8AxNH/AAnPiP8A6CP/AJBj/wDia5uigD1vw3oeneJNFt9W1u2+06hcbvMl3sm7axUc\n" +
            "KQOFUDgVpf8ACDeHP+gd/wCRpP8A4qj4b/8AIlaf/wBtP/RjV0lAHN/8IN4c/wCgd/5Gk/8AiqP+\n" +
            "EG8Of9A7/wAjSf8AxVdJRQBzf/CDeHP+gd/5Gk/+Ko/4Qbw5/wBA7/yNJ/8AFV0lFAHN/wDCDeHP\n" +
            "+gd/5Gk/+Ko/4Qbw5/0Dv/I0n/xVdJRQB5J4j1zUfDWtXOk6Jc/ZtPt9vlxbFfbuUMeWBPJYnk96\n" +
            "zf8AhOfEf/QR/wDIMf8A8TS/Eb/kdNR/7Z/+i1rmqAOk/wCE58R/9BH/AMgx/wDxNH/Cc+I/+gj/\n" +
            "AOQY/wD4mubooA6T/hOfEf8A0Ef/ACDH/wDE0f8ACc+I/wDoI/8AkGP/AOJrm6KAOk/4TnxH/wBB\n" +
            "H/yDH/8AE0f8Jz4j/wCgj/5Bj/8Aia5uigD1vw3oeneJNFt9W1u2+06hcbvMl3sm7axUcKQOFUDg\n" +
            "Vpf8IN4c/wCgd/5Gk/8AiqPhv/yJWn/9tP8A0Y1dJQBzf/CDeHP+gd/5Gk/+Ko/4Qbw5/wBA7/yN\n" +
            "J/8AFV0lFAHN/wDCDeHP+gd/5Gk/+Ko/4Qbw5/0Dv/I0n/xVdJRQBzf/AAg3hz/oHf8AkaT/AOKo\n" +
            "/wCEG8Of9A7/AMjSf/FV0lFAHkniPXNR8Na1c6Tolz9m0+32+XFsV9u5Qx5YE8lieT3rN/4TnxH/\n" +
            "ANBH/wAgx/8AxNL8Rv8AkdNR/wC2f/ota5qgDpP+E58R/wDQR/8AIMf/AMTR/wAJz4j/AOgj/wCQ\n" +
            "Y/8A4mubooA6T/hOfEf/AEEf/IMf/wATR/wnPiP/AKCP/kGP/wCJrm6KAOk/4TnxH/0Ef/IMf/xN\n" +
            "H/Cc+I/+gj/5Bj/+Jrm6KAPW/Deh6d4k0W31bW7b7TqFxu8yXeybtrFRwpA4VQOBWl/wg3hz/oHf\n" +
            "+RpP/iqPhv8A8iVp/wD20/8ARjV0lABRRRQAUUUUAFFFFAHifxG/5HTUf+2f/ota5qul+I3/ACOm\n" +
            "o/8AbP8A9FrXNUAFFFFABRRRQAUUUUAe2/Df/kStP/7af+jGrpK5v4b/APIlaf8A9tP/AEY1dJQA\n" +
            "UUUUAFFFFABRRRQB4n8Rv+R01H/tn/6LWuarpfiN/wAjpqP/AGz/APRa1zVABRRRQAUUUUAFFFFA\n" +
            "Htvw3/5ErT/+2n/oxq6Sub+G/wDyJWn/APbT/wBGNXSUAFFFFABRRRQAUUUUAeJ/Eb/kdNR/7Z/+\n" +
            "i1rmq6X4jf8AI6aj/wBs/wD0Wtc1QAUUUUAFFFFABRRRQB7b8N/+RK0//tp/6Maukrm/hv8A8iVp\n" +
            "/wD20/8ARjV0lABRRRQAUUUUAFFFFAHifxG/5HTUf+2f/ota5qul+I3/ACOmo/8AbP8A9FrXNUAF\n" +
            "FFFABRRRQAUUUUAe2/Df/kStP/7af+jGrpK5v4b/APIlaf8A9tP/AEY1dJQAUUUUAFFFFABRRRQB\n" +
            "4n8Rv+R01H/tn/6LWuarpfiN/wAjpqP/AGz/APRa1zVABRRRQAUUUUAFFFFAHtvw3/5ErT/+2n/o\n" +
            "xq6Sub+G/wDyJWn/APbT/wBGNXSUAf/Z\n";

    public static String getBase64(String str) {
        byte[] b = null;
        String s = null;
        b = str.getBytes(StandardCharsets.UTF_8);//update(...)
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }

    public static String base64ToString(String base64) {
        String s = null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            s = decoder.decodeBuffer(base64).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static byte[] base64ToByte(String base64) {
        byte[] bytes = new byte[]{};
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            bytes = decoder.decodeBuffer(base64);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * @param base64sString 编码字符串
     */
    public String base64StringToPDF(String base64sString, String fileName, String fileType) {
        BASE64Decoder decoder = new BASE64Decoder();
        BufferedInputStream bin = null;
        FileOutputStream fout = null;
        BufferedOutputStream bout = null;
        String fileAddress = "D:/test/" + fileName + ".pdf";
        try {
            //将base64编码的字符串解码成字节数组
            byte[] bytes = decoder.decodeBuffer(base64sString);
            //byte[] bytes = Base64.decodeBase64(base64sString);
            //创建一个将bytes作为其缓冲区的ByteArrayInputStream对象
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            //创建从底层输入流中读取数据的缓冲输入流对象
            bin = new BufferedInputStream(bais);
            //指定输出的文件
            File file = new File(fileAddress);
            //创建到指定文件的输出流
            fout = new FileOutputStream(file);
            //为文件输出流对接缓冲输出流对象
            bout = new BufferedOutputStream(fout);
            byte[] buffers = new byte[1024];
            int len = bin.read(buffers);
            while (len != -1) {
                bout.write(buffers, 0, len);
                len = bin.read(buffers);
            }
            //刷新此输出流并强制写出所有缓冲的输出字节，必须这行代码，否则有可能有问题
            bout.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bin.close();
                fout.close();
                bout.close();
                return fileAddress;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileAddress;
    }
}
