{\rtf1\ansi\ansicpg936\cocoartf2511
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;\f1\fnil\fcharset134 PingFangSC-Regular;}
{\colortbl;\red255\green255\blue255;\red203\green36\blue57;\red27\green31\blue35;\red109\green109\blue109;
\red8\green68\blue184;\red87\green96\blue106;}
{\*\expandedcolortbl;;\csgenericrgb\c79608\c14118\c22353;\csgenericrgb\c10588\c12157\c13725;\csgenericrgb\c42745\c42745\c42745;
\csgenericrgb\c3137\c26667\c72157;\csgenericrgb\c34118\c37647\c41569;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf2 class \cf3 Solution \{\
    \cf2 public int\cf3 [][] merge(\cf2 int\cf3 [][] arr) \{\
        Arrays.parallelSort(arr\cf4 , \cf3 Comparator.comparingInt(x -> x[\cf5 0\cf3 ]))\cf4 ;\
\
        \cf3 LinkedList\cf2 <int\cf3 []\cf2 > \cf3 list \cf2 = new \cf3 LinkedList\cf2 <>\cf3 ()\cf4 ;\
        \cf2 for \cf3 (\cf2 int \cf3 i \cf2 = \cf5 0\cf4 ; \cf3 i \cf2 < \cf3 arr.length\cf4 ; \cf3 i\cf2 ++\cf3 ) \{\
            \cf2 if \cf3 (list.size() \cf2 == \cf5 0 \cf2 || \cf3 list.getLast()[\cf5 1\cf3 ] \cf2 < \cf3 arr[i][\cf5 0\cf3 ]) \{\
                list.add(arr[i])\cf4 ;\cf6 //
\f1 \'bc\'af\'ba\'cf\'ce\'aa\'bf\'d5\'a3\'ac\'bb\'f2\'b2\'bb\'c2\'fa\'d7\'e3\'cc\'f5\'bc\'fe\'a3\'ac\'cf\'f2\'ba\'f3\'d0\'c2\'d4\'f6
\f0 \
            \cf3 \} \cf2 else \cf3 \{\cf6 //
\f1 \'c2\'fa\'d7\'e3\'cc\'f5\'bc\'fe\'a3\'ac\'bc\'af\'ba\'cf\'d7\'ee\'ba\'f3\'d4\'aa\'cb\'d8\'b5\'c4
\f0 end=
\f1 \'d7\'ee\'b4\'f3\'d6\'b5
\f0 \
                \cf3 list.getLast()[\cf5 1\cf3 ] \cf2 = \cf3 Math.max(list.getLast()[\cf5 1\cf3 ]\cf4 , \cf3 arr[i][\cf5 1\cf3 ])\cf4 ;\
            \cf3 \}\
        \}\
        \cf2 int\cf3 [][] res \cf2 = new int\cf3 [list.size()][\cf5 2\cf3 ]\cf4 ;\cf6 //
\f1 \'c9\'fa\'b3\'c9\'bd\'e1\'b9\'fb\'ca\'fd\'d7\'e9
\f0 \
        \cf2 int \cf3 index \cf2 = \cf5 0\cf4 ;\
        \cf2 while \cf3 (\cf2 !\cf3 list.isEmpty()) \{\cf6 //
\f1 \'b1\'e9\'c0\'fa\'bc\'af\'ba\'cf
\f0 \
            \cf3 res[index\cf2 ++\cf3 ] \cf2 = \cf3 list.removeFirst()\cf4 ;\cf6 //
\f1 \'c9\'be\'b3\'fd\'bc\'af\'ba\'cf\'ca\'d7\'d4\'aa\'cb\'d8
\f0 \
        \cf3 \}\
        \cf2 return \cf3 res\cf4 ;\
    \cf3 \}\
\}\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0
\cf0 \
}