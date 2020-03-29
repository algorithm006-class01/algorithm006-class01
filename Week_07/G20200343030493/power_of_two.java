{\rtf1\ansi\ansicpg936\cocoartf2511
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;\red203\green36\blue57;\red27\green31\blue35;\red8\green68\blue184;
\red109\green109\blue109;}
{\*\expandedcolortbl;;\csgenericrgb\c79608\c14118\c22353;\csgenericrgb\c10588\c12157\c13725;\csgenericrgb\c3137\c26667\c72157;
\csgenericrgb\c42745\c42745\c42745;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf2 class \cf3 Solution \{\
    \cf2 public boolean \cf3 isPowerOfTwo(\cf2 int \cf3 n) \{\
        \cf2 if \cf3 (n \cf2 == \cf4 0\cf3 ) \cf2 return false\cf5 ;\
        \cf2 long \cf3 x \cf2 = \cf3 (\cf2 long\cf3 ) n\cf5 ;\
        \cf2 return \cf3 (x \cf2 & \cf3 (\cf2 -\cf3 x)) \cf2 == \cf3 x\cf5 ;\
    \cf3 \}\
\}\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0
\cf0 \
}