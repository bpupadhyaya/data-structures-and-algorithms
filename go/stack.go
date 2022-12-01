package main

import (
	"fmt"
)

type Stack struct {
	stackData []interface{}
}

func (myStack *Stack) Push(value interface{}) {
	myStack.stackData = append(myStack.stackData, value)
}

func (myStack *Stack) Pop() interface{} {
	stackLength := len(myStack.stackData)
	topValue := myStack.stackData[stackLength-1]
	myStack.stackData = myStack.stackData[:stackLength-1]
	return topValue
}

func (myStack Stack) Top() interface{} {
	stackLength := len(myStack.stackData)
	return myStack.stackData[stackLength-1]
}

func (myStack Stack) Len() int {
	return len(myStack.stackData)
}

func (myStack Stack) IsEmpty() bool {
	return len(myStack.stackData) == 0
}

func (myStack Stack) Print() {
	fmt.Println(myStack.stackData)
}

func main() {
	myStack := &Stack{}
	myStack.Push(5)
	myStack.Push(10)
	myStack.Print()
	fmt.Println(myStack.Len())
	fmt.Println(myStack.Pop())
	fmt.Print(myStack.Top(), " ")
	fmt.Println(myStack.Top())
	fmt.Println(myStack.IsEmpty())
}
