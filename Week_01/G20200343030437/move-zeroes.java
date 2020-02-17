        public void moveZeroes(int[] array) {
            int length = array.length;
            int num = 0; // 代表0的个数
            //指针2
            int j = 0;
            //循环数组
            for (int i = 0; j < length; i++) { //指针1
                //判断是否为0
                if (array[j] == 0) {
                    num++;
                    //如果为0，先判断下一个数是否为0，
                    for (j++; j < length; j++) {
                        if (array[j] != 0) {
                            // 下一个数超前移动
                            array[i] = array[j];
                            break;
                        }
                        num++;

                    }
                }
                if (j < length) {
                    array[i] = array[j];
                }
                j++;
            }
            //遍历完成后将num个0更新至数组末尾
            for (int k = 0; k < num; k++) {
                array[length - 1 - k] = 0;
            }
            for (int t = 0; t < length; t++) {
                System.out.println(array[t]);
            }
        }
