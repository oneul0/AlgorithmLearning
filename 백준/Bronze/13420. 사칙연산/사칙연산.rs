use std::io::{self, BufRead};

fn main() {
    let stdin = io::stdin();
    let mut lines = stdin.lock().lines();

    let t_str = lines.next().unwrap().unwrap();
    let t: i32 = t_str.trim().parse().unwrap();

    let mut output = String::new();

    for _ in 0..t {
        if let Some(Ok(line)) = lines.next() {
            let tokens: Vec<&str> = line.split_whitespace().collect();

            let a: i64 = tokens[0].parse().unwrap();
            let op = tokens[1];
            let b: i64 = tokens[2].parse().unwrap();
            let expected: i64 = tokens[4].parse().unwrap();

            let actual = match op {
                "+" => a + b,
                "-" => a - b,
                "*" => a * b,
                "/" => a / b,
                _ => unreachable!(),
            };

            if actual == expected {
                output.push_str("correct\n");
            } else {
                output.push_str("wrong answer\n");
            }
        }
    }

    print!("{}", output);
}