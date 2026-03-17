use std::io::{self, BufRead};

fn main() {
    let stdin = io::stdin();
    let mut lines = stdin.lock().lines();

    let t: usize = lines.next().unwrap().unwrap().trim().parse().unwrap();

    for _ in 0..t {
        if let Some(Ok(line)) = lines.next() {
            let nums: Vec<i32> = line
                .split_whitespace()
                .map(|s| s.parse().unwrap())
                .collect();
            
            let a = nums[0];
            let b = nums[1];

            let base = a % 10;

            if base == 0 {
                println!("10");
            } else {
                let exp = (b - 1) % 4 + 1;
                let mut result = 1;
                
                for _ in 0..exp {
                    result = (result * base) % 10;
                }
                println!("{}", result);
            }
        }
    }
}