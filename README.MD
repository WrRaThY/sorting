What is this?
-------------
implementation of some basic sorting algorithms

Why are you here?
-----------------
I have no bloody idea!

Why I posted it?
----------------
while preparing for an interview I decided to implement some sorting algorithms 
as a revision of what I did years back...  
given enough time I'll accidentally delete it from my drive and will have to implement it again before another interview...  
so why not just have it on GitHub?

main differences between my implementation and ones I've see on the internets are:  
1. my variables actually have names (no, `a` is NOT a name! neither are `b` and `c`. seriously...)  
2. I even have some methods with more or less descriptive names  
3. I implemented those sorting algorithms with generics, so they can be used to sort everything, not just integers...  
4. I have tests. no more running stuff from the main method and testing with your own eyes!  

And lets be honest... it's a little bit easier to read this:  

    public List<T> sort(List<T> input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        for (int currentIndex = 0; currentIndex < input.size(); currentIndex++) {
            bubbleToTheRight(input, currentIndex);
        }
        return input;
    }

    private void bubbleToTheRight(List<T> input, int placesSortedAtTheEnd) {
        int maxIndex = input.size() - placesSortedAtTheEnd;

        for (int currentIndex = 1; currentIndex < maxIndex; currentIndex++) {
            int indexBeforeCurrent = currentIndex - 1;
            if (input.get(indexBeforeCurrent).compareTo(input.get(currentIndex)) > 0){
                Collections.swap(input, indexBeforeCurrent, currentIndex);
            }
        }
    }
    
so you can see that `currentIndex` becomes a `placesSortedAtTheEnd`, which means we will iterate over a sub-list  
or that there is some `- 1`, which can be easily missed, if you're not paying attention.   
one could argue, that there are more variables created, so it's not optimal and... that's right.  
But this piece of code is used to `understand` an algorithm...

compared to that:  

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements  
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }
    
and see that you have no bloody idea whats going on, expect for the fact that you swap some elements...

In the end - I hope that if you stumble upon this it will actually help you understand those algorithms better.

Ah! And if I made some terrible mistake - please let me know!

ps. I did not get to the hard ones, but it's a start