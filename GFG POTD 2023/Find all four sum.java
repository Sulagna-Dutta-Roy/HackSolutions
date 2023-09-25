ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = arr.length;
        
        Arrays.sort(arr); // Sort the array to make it easier to find combinations
        
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int left = j + 1;
                int right = n - 1;
                
                while (left < right) {
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    
                    if (sum == k) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[left]);
                        temp.add(arr[right]);
                        res.add(temp);
                        
                        while (left < right && arr[left] == temp.get(2)) left++; // Skip duplicates
                        while (left < right && arr[right] == temp.get(3)) right--; // Skip duplicates
                    } else if (sum < k) {
                        left++;
                    } else {
                        right--;
                    }
                }
                
                while (j + 1 < n - 2 && arr[j + 1] == arr[j]) j++; // Skip duplicates
            }
            
            while (i + 1 < n - 3 && arr[i + 1] == arr[i]) i++; // Skip duplicates
        }
        
        return res;
