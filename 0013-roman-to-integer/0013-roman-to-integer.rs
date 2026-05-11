impl Solution {
    pub fn roman_to_int(s: String) -> i32 {
        let chars: Vec<char> = s.chars().collect();
        let mut result= 0;
        for i in 0..chars.len(){
            let cur = Self::value(chars[i]);

            if i+1 < chars.len() {
                let next = Self::value(chars[i+1]);

                if cur < next {
                    result -= cur;
                }
                else{
                    result += cur;
                }
            }
            else{
                result += cur;
            }
        }

        result
    }

    fn value(c : char) -> i32 {
        match c{
            'I' => 1,
            'V' => 5,
            'X' => 10,
            'L' => 50,
            'C' => 100,
            'D' => 500,
            'M' => 1000,
            _ => 0,
        }
    }
}