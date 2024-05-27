<h2><a href="https://leetcode.com/problems/generate-parentheses/">22. Generate Parentheses</a></h2><h3>Medium</h3><hr><div><p>Given <code>n</code> pairs of parentheses, write a function to <em>generate all combinations of well-formed parentheses</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> n = 3
<strong>Output:</strong> ["((()))","(()())","(())()","()(())","()()()"]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> ["()"]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 8</code></li>
</ul>
</div>

<h1>Solution</h1>
<img width="938" alt="image" src="https://github.com/santos019/LeetHub/assets/85140461/cf7b6e98-4fa9-4a89-ad02-ce9ee6a9a7b7">
<p>조건1. left의 수가 right보다 커야 right를 문자열에 추가할 수 있다. </p>
<p>조건2. left가 1 이상인 경우, left를 문자열에 추가할 수 있다.</p>

