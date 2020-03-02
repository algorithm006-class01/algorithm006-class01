//2020-2-27 complete

bool lemonadeChange(int* bills, int billsSize){
    int five = 0, ten = 0;
    int i;
    int bill;

    for ( i = 0; i < billsSize; i++ ) {
        bill = *( bills+i );

        //process
        if ( bill == 5 ) {
            five++;
        } else if ( bill == 10 && five > 0 ) {
            five--;
            ten++;
        } else if ( bill == 20 && five > 0 && ten > 0 ) {
            five--;
            ten--;
        } else if ( bill == 20 && five > 2 ) {
            five-=3;
        } else {
            return false;
        }
            
    }
    return true;
}


