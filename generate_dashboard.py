import os
import json
from datetime import datetime

def scan_directory(directory):
    """Scan a directory and extract problem information."""
    problems = []

    if not os.path.exists(directory):
        return problems

    for filename in os.listdir(directory):
        filepath = os.path.join(directory, filename)

        # Skip directories
        if os.path.isdir(filepath):
            continue

        # Extract problem name and language
        name, ext = os.path.splitext(filename)
        ext = ext.lstrip('.')

        # Map extensions to languages
        lang_map = {
            'java': 'java',
            'py': 'python',
            'cpp': 'cpp',
            'c': 'c',
            'cs': 'csharp',
            'go': 'go',
            'js': 'javascript'
        }

        lang = lang_map.get(ext, 'unknown')

        # Create problem URL (Kattis uses lowercase)
        problem_slug = name.replace('_', '').lower()
        url = f'https://open.kattis.com/problems/{problem_slug}'

        problems.append({
            'name': name,
            'lang': lang,
            'url': url
        })

    return problems

def generate_dashboard_html():
    """Generate the dashboard HTML with embedded problem data."""

    # Scan directories
    solved_dir = 'Solved'
    backlog_dir = 'Not_Solved_Backlog'

    solved_problems = scan_directory(solved_dir)
    backlog_problems = scan_directory(backlog_dir)

    # Calculate statistics
    java_count = len([p for p in solved_problems if p['lang'] == 'java'])
    python_count = len([p for p in solved_problems if p['lang'] == 'python'])
    cpp_count = len([p for p in solved_problems if p['lang'] == 'cpp'])

    print(f"Found {len(solved_problems)} solved problems")
    print(f"  - Java: {java_count}")
    print(f"  - Python: {python_count}")
    print(f"  - C++: {cpp_count}")
    print(f"Found {len(backlog_problems)} backlog problems")

    # Read the template HTML
    with open('dashboard.html', 'r', encoding='utf-8') as f:
        html_content = f.read()

    # Create JavaScript data embedding
    problems_data = f"""
        const solvedProblems = {json.dumps(solved_problems, indent=12)};
        const backlogProblems = {json.dumps(backlog_problems, indent=12)};
    """

    # Replace the placeholder data in the script
    # Find the section where we define solvedProblems and backlogProblems
    start_marker = "const solvedProblems = [];"
    end_marker = "const backlogProblems = [];"

    if start_marker in html_content and end_marker in html_content:
        start_idx = html_content.find(start_marker)
        end_idx = html_content.find(end_marker) + len(end_marker)

        html_content = (
            html_content[:start_idx] +
            problems_data.strip() +
            html_content[end_idx:]
        )

    # Also remove the sample data generation function call
    html_content = html_content.replace(
        'await generateProblemsData();',
        '// Data embedded at build time\n            initializeDashboard();'
    )

    # Remove the generateProblemsData function entirely
    func_start = html_content.find('// Generate problems data from existing files')
    if func_start != -1:
        func_end = html_content.find('initializeDashboard();', func_start)
        if func_end != -1:
            func_end = html_content.find('}', func_end) + 1
            html_content = html_content[:func_start] + html_content[func_end:]

    # Update the loadProblemsFromDirectory function
    html_content = html_content.replace(
        'async function loadProblemsFromDirectory() {',
        'function loadProblemsFromDirectory() {'
    )

    # Write the updated HTML
    output_file = 'kattis_dashboard.html'
    with open(output_file, 'w', encoding='utf-8') as f:
        f.write(html_content)

    print(f"\n[SUCCESS] Dashboard generated successfully: {output_file}")
    print(f"[INFO] Open {output_file} in your browser to view your progress!")

    return output_file

if __name__ == '__main__':
    generate_dashboard_html()
