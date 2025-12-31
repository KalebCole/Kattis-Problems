# 🚀 GitHub Pages Deployment Guide

Your Kattis Dashboard is ready for deployment to GitHub Pages with automated builds!

## 📋 Quick Deploy

### Windows
```bash
deploy.bat
```

### Linux/Mac
```bash
./deploy.sh
```

## 🔧 First-Time Setup

After running the deploy script for the first time, you need to enable GitHub Pages:

1. **Go to your repository settings:**
   ```
   https://github.com/KalebCole/Kattis-Problems/settings/pages
   ```

2. **Configure GitHub Pages:**
   - Under "Build and deployment"
   - **Source:** Select "GitHub Actions"
   - Click "Save"

3. **Wait for deployment:**
   - Check the "Actions" tab to see the workflow running
   - First deployment takes 2-3 minutes

4. **Your dashboard will be live at:**
   ```
   https://kalebcole.github.io/Kattis-Problems/
   ```

## 🔄 Automated Workflow

Once set up, your dashboard will automatically update whenever you push to master:

1. **Solve a new problem** → Add to `Solved/` directory
2. **Commit and push:**
   ```bash
   git add Solved/YourNewProblem.java
   git commit -m "Solved: YourNewProblem"
   git push origin master
   ```
3. **GitHub Actions automatically:**
   - Runs `generate_dashboard.py`
   - Generates fresh `kattis_dashboard.html`
   - Deploys to GitHub Pages
   - Updates live site in ~2 minutes

## 📁 What Gets Deployed

The workflow (`.github/workflows/deploy-dashboard.yml`) does:

1. ✅ Checks out your repository
2. ✅ Sets up Python 3.11
3. ✅ Runs `generate_dashboard.py` to scan your problems
4. ✅ Generates `kattis_dashboard.html`
5. ✅ Copies it as `index.html` to deployment directory
6. ✅ Deploys to GitHub Pages

## 🎯 Manual Deployment

If you want to manually trigger deployment without pushing code:

1. Go to: `https://github.com/KalebCole/Kattis-Problems/actions`
2. Click on "Deploy Kattis Dashboard to GitHub Pages"
3. Click "Run workflow" button
4. Select "master" branch
5. Click "Run workflow"

## 🔍 Monitoring Deployments

### Check Build Status

- **Actions Tab:** `https://github.com/KalebCole/Kattis-Problems/actions`
- Look for green checkmarks ✅ (success) or red X ❌ (failure)

### View Live Dashboard

- **Production URL:** `https://kalebcole.github.io/Kattis-Problems/`
- Updates appear within 2-3 minutes after workflow completes

## 🛠️ Troubleshooting

### "Pages build and deployment" failing?

**Solution:** Enable GitHub Pages in repository settings
```
Settings → Pages → Source: GitHub Actions
```

### Dashboard shows old data?

**Solutions:**
1. Hard refresh your browser (Ctrl + Shift + R)
2. Clear browser cache
3. Check if the workflow ran successfully in Actions tab
4. Verify `generate_dashboard.py` completed without errors

### Workflow permission errors?

**Solution:** Update repository permissions
```
Settings → Actions → General → Workflow permissions
→ Select "Read and write permissions"
```

### Python dependencies missing?

The workflow uses standard library only, but if you add features:
```yaml
# Add to deploy-dashboard.yml after "Setup Python"
- name: Install dependencies
  run: |
    pip install -r requirements.txt
```

## 📊 Deployment Structure

```
Your Repository
├── Solved/                 # Your solved problems
├── Not_Solved_Backlog/    # Problems to solve
├── .github/
│   └── workflows/
│       └── deploy-dashboard.yml  # GitHub Actions config
├── dashboard.html         # Template (committed)
├── generate_dashboard.py  # Generator script (committed)
├── kattis_dashboard.html # Generated file (gitignored, built by CI)
└── deploy.bat/sh         # Deployment scripts
```

## 🔐 Security Notes

- The workflow runs on GitHub's servers
- No credentials needed (uses GitHub's built-in tokens)
- Only deploys public repository content
- Dashboard is static HTML (no server-side code)

## 🎨 Custom Domain (Optional)

To use a custom domain like `kattis.yourdomain.com`:

1. **Add CNAME file:**
   ```bash
   echo "kattis.yourdomain.com" > CNAME
   git add CNAME
   git commit -m "Add custom domain"
   git push
   ```

2. **Update workflow:**
   ```yaml
   # Add to deploy-dashboard.yml in "Create deployment directory"
   cp CNAME _site/CNAME
   ```

3. **Configure DNS:**
   - Add CNAME record: `kattis` → `kalebcole.github.io`

4. **Update GitHub settings:**
   - Settings → Pages → Custom domain → Enter your domain
   - Wait for DNS check ✅

## 📱 Share Your Dashboard

Once deployed, you can:
- Add the link to your GitHub profile README
- Share on LinkedIn/Twitter
- Include in your resume/portfolio
- Embed in other websites (it's just an iframe!)

Example README badge:
```markdown
[![Kattis Dashboard](https://img.shields.io/badge/Kattis-Dashboard-00ffff?style=for-the-badge)](https://kalebcole.github.io/Kattis-Problems/)
```

## 🔄 Keep Dashboard Updated

### Option 1: Automatic (Recommended)
Every time you push to master, dashboard auto-updates!

### Option 2: On-Demand
Run the deploy script manually when you want to update:
```bash
deploy.bat  # Windows
./deploy.sh # Linux/Mac
```

### Option 3: Local Preview Before Deploy
```bash
# 1. Generate locally
python generate_dashboard.py

# 2. Preview in browser
start kattis_dashboard.html  # Windows
open kattis_dashboard.html   # Mac
xdg-open kattis_dashboard.html # Linux

# 3. If satisfied, commit and push
git add Solved/*
git commit -m "Solved more problems"
git push origin master
```

## 📈 Analytics (Optional)

Add Google Analytics or other tracking:

1. Edit `dashboard.html` before `</head>`:
   ```html
   <!-- Google Analytics -->
   <script async src="https://www.googletagmanager.com/gtag/js?id=G-XXXXXXXXXX"></script>
   <script>
     window.dataLayer = window.dataLayer || [];
     function gtag(){dataLayer.push(arguments);}
     gtag('js', new Date());
     gtag('config', 'G-XXXXXXXXXX');
   </script>
   ```

2. Commit and push - tracking enabled on next deployment!

## ✅ Deployment Checklist

- [ ] Run `deploy.bat` or `./deploy.sh`
- [ ] Enable GitHub Pages (Settings → Pages → GitHub Actions)
- [ ] Wait 2-3 minutes for first deployment
- [ ] Visit `https://kalebcole.github.io/Kattis-Problems/`
- [ ] Verify dashboard displays correctly
- [ ] Test search and filter functionality
- [ ] Check that problem links work
- [ ] Bookmark your live dashboard!

---

## 🎉 You're All Set!

Your dashboard will now automatically update every time you push new solutions to GitHub. Keep solving problems and watch your progress grow! 🚀

**Live Dashboard:** https://kalebcole.github.io/Kattis-Problems/

**Questions?** Check the Actions tab for build logs or open an issue.
