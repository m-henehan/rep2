#Implementation of Two Player Tic-Tac-Toe game in Python.

''' We will make the board using dictionary 
    in which keys will be the location(i.e : top-left,mid-right,etc.)
    and initialliy it's values will be empty space and then after every move 
    we will change the value according to player's choice of move. '''

theBoard = {'1': 'X' , '2': 'X' , '3': 'X' , '4': 'X' , '5': 'X' , '6': 'X' , '7': 'X' , '8': 'X' ,
            '9': 'X' , '10': 'X' , '11': 'X' , '12': 'X' ,'13': ' ' , '14': ' ' , '15': ' ' , '16': ' ',
            '17': ' ' , '18': ' ' , '19': ' ' , '20': ' ' , '21': 'O' , '22': 'O' , '23': 'O' , '24': 'O' ,
            '25': 'O' , '26': 'O' , '27': 'O' , '28': 'O' ,'29': 'O' , '30': 'O' , '31': 'O' , '32': 'O'}

board_keys = []

for key in theBoard:
    board_keys.append(key)

''' We will have to print the updated board after every move in the game and 
    thus we will make a function in which we'll define the printBoard function
    so that we can easily print the board everytime by calling this function. '''

def printBoard(board):
    print(board['1'] + '|' + '#' + '|' + board['2'] + '|' + '#' + '|' + board['3'] + '|' + '#' + '|' + board['4'] + '|' + '#')
    print('-+-+-+-+-+-+-+-')
    print('#' + '|' + board['5'] + '|' + '#' + '|' + board['6'] + '|' + '#' + '|' + board['7'] + '|' + '#' + '|' + board['8'])
    print('-+-+-+-+-+-+-+-')
    print(board['9'] + '|' + '#' + '|' + board['10'] + '|' + '#' + '|' + board['11'] + '|' + '#' + '|' + board['12'] + '|' + '#')
    print('-+-+-+-+-+-+-+-')
    print('#' + '|' + board['13'] + '|' + '#' + '|' + board['14'] + '|' + '#' + '|' + board['15'] + '|' + '#' + '|' + board['16'])
    print('-+-+-+-+-+-+-+-')
    print(board['17'] + '|' + '#' + '|' + board['18'] + '|' + '#' + '|' + board['19'] + '|' + '#' + '|' + board['20'] + '|' + '#')
    print('-+-+-+-+-+-+-+-')
    print('#' + '|' + board['21'] + '|' + '#' + '|' + board['22'] + '|' + '#' + '|' + board['23'] + '|' + '#' + '|' + board['24'])
    print('-+-+-+-+-+-+-+-')
    print(board['25'] + '|' + '#' + '|' + board['26'] + '|' + '#' + '|' + board['27'] + '|' + '#' + '|' + board['28'] + '|' + '#')
    print('-+-+-+-+-+-+-+-')
    print('#' + '|' + board['29'] + '|' + '#' + '|' + board['30'] + '|' + '#' + '|' + board['31'] + '|' + '#' + '|' + board['32'])

# Now we'll write the main function which has all the gameplay functionality.
def game():

    turn = 'X'
    notTurn = 'O'
    counter = 0
    xWinCount = 12
    oWinCount = 12


# Check moves etc
    while oWinCount>0 and xWinCount>0:
        printBoard(theBoard)
        print("It's your turn," + turn + ". Move which piece?")
        piece = input()
        print("Where do you want to move it?")
        move = input()

        while theBoard[piece] == ' ' or theBoard[piece] == notTurn:
            print("You do not have a piece here. Choose another.")
            piece = input()

        while theBoard[move] == turn:
             print("You already have a piece here")
             move = input()
             
        if turn == 'X':
            if piece==1 or piece==8 or piece==9 or piece==16 or piece==17 or piece==24 or piece==25:
                if move == piece+4:
                    theBoard[move] = turn
                    theBoard[piece] = ' '
                    counter += 1

                else:
                    print("You cannot move here.")

            if (piece>9 and piece<13) or (
        theBoard[move] = turn
        theBoard[piece] = ' '
        counter += 1

        # Now we will check if there is a winner yet
        for i in theBoard:
            if theBoard[i] == 'X':
                xWinCount += 1
            elif theBoard[i] == 'O':
                oWinCount += 1

        if xWinCount == 0:
            printBoard(theBoard)
            print("O is our winner! Congratulations!")
            break
        elif oWinCount == 0:
            printBoard(theBoard)
            print("X is our winner! Congratulations!")
            break
        elif xWinCount>oWinCount & oWinCount>0:
            print("X is winning so far!")
            xWinCount = 0
            oWinCount = 0
        elif xWinCount<oWinCount & xWinCount>0:
            print("O is winning so far!")
            xWinCount = 0
            oWinCount = 0

        # Now we have to change the player after every move.
        if turn =='X':
            turn = 'O'
            notTurn = 'X'
        else:
            turn = 'X'
            notTurn = 'O'
    
    # Now we will ask if player wants to restart the game or not.
    restart = input("Do want to play Again?(y/n)")
    if restart == "y" or restart == "Y":  
        for key in board_keys:
            theBoard[key] = " "

        game()

if __name__ == "__main__":
    game()
